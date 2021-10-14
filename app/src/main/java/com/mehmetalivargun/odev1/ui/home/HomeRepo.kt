package com.mehmetalivargun.odev1.ui.home

import com.mehmetalivargun.odev1.api.RetrofitApi
import com.mehmetalivargun.odev1.data.api.Result
import com.mehmetalivargun.odev1.data.api.ResultX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepo {
    private val retrofit = RetrofitApi.retrofitService
    suspend fun fetchMovies(): Flow<Any> = flow {


        val response = try {
            retrofit.listAllPopularMovies()
        } catch (ex: Exception) {
            null
        }



        when(response?.code()){
            null -> emit(MovieListResult.Failure)
            200 -> {
                val movies = response.body()!!.results
                emit(MovieListResult.Success(movies))

            }
            else -> emit(MovieListResult.UnexpectedError)
        }

    }

    suspend fun fetchActors(): Flow<Any> = flow {



        val response = try {
            retrofit.listAllPopularActors()
        } catch (ex: Exception) {
            null
        }



        when(response?.code()){
            null -> emit(ActorListResult.Failure)
            200 -> {
                val actors = response.body()!!.results
                emit(ActorListResult.Success(actors))

            }
            else -> emit(ActorListResult.UnexpectedError)
        }

    }

    sealed class MovieListResult {
        class Success(val results: List<Result>) : MovieListResult()
        object Failure : MovieListResult()
        object UnexpectedError : MovieListResult()
    }
    sealed class ActorListResult {
        class Success(val results: List<ResultX>) : ActorListResult()
        object Failure : ActorListResult()
        object UnexpectedError : ActorListResult()
    }

}