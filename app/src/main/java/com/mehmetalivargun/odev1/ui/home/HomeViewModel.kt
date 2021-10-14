package com.mehmetalivargun.odev1.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehmetalivargun.odev1.data.api.Result
import com.mehmetalivargun.odev1.data.api.ResultX
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private  val repo : HomeRepo) : ViewModel() {

    private val _movies = MutableLiveData<List<Result>>()
    val movies: LiveData<List<Result>> = _movies

    private val _actors = MutableLiveData<List<ResultX>>()
    val actors: LiveData<List<ResultX>> = _actors

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    init {
        fetchActors()
        fetchMovies()


    }

    private fun fetchMovies()=viewModelScope.launch {
        repo.fetchMovies().collect {
            when(it){
                is HomeRepo.MovieListResult.Success -> onSuccess(it.results)
                HomeRepo.MovieListResult.Failure-> onFailure()
                HomeRepo.MovieListResult.UnexpectedError -> onUnexpectedError()
            }
        }
    }
    private fun fetchActors()=viewModelScope.launch {
        repo.fetchActors().collect {
            when(it){
                is HomeRepo.ActorListResult.Success -> onSuccessActors(it.results)
                HomeRepo.ActorListResult.Failure-> onFailure()
                HomeRepo.ActorListResult.UnexpectedError -> onUnexpectedError()
            }
        }
    }

    private fun onSuccessActors(results: List<ResultX>) {
        Log.e("SuccessA",results[0].profile_path)
        _actors.value=results
    }


    private fun onUnexpectedError() {
        TODO("Not yet implemented")
    }

    private fun onFailure() {
        TODO("Not yet implemented")
    }

    private fun onSuccess(movies: List<Result>) {
        Log.e("Success",movies[0].title)
        _text.value=""
        _movies.value=movies
    }


}