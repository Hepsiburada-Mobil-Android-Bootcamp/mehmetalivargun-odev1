package com.mehmetalivargun.odev1

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.mehmetalivargun.odev1.data.api.Result
import androidx.databinding.BindingAdapter
import com.mehmetalivargun.odev1.data.api.ResultX
import com.mehmetalivargun.odev1.ui.home.ActorAdapter
import com.mehmetalivargun.odev1.ui.home.MovieAdapter
val movieAdapter = MovieAdapter()
val actorAdapter = ActorAdapter()
@BindingAdapter("app:movies")
fun RecyclerView.movies(movies: List<Result>?) {
    if (adapter != movieAdapter) {
        adapter = movieAdapter
    }
    movieAdapter.submitList(movies.orEmpty())


}
@BindingAdapter("app:actors")
fun RecyclerView.actors(actors: List<ResultX>?) {
    if (adapter != actorAdapter) {
        adapter = actorAdapter
    }
    actorAdapter.submitList(actors.orEmpty())


}




