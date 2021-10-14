package com.mehmetalivargun.odev1.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.mehmetalivargun.odev1.data.api.Result
import com.mehmetalivargun.odev1.databinding.MovieItemBinding
import com.bumptech.glide.request.RequestOptions
import eightbitlab.com.blurview.RenderScriptBlur


class MovieAdapter (): ListAdapter<Result, MovieAdapter.MovieHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )

        //blurview library usage for bluring rate of movie and like button

        binding.blurView.apply {
            outlineProvider = ViewOutlineProvider.BACKGROUND
            clipToOutline = true
            setupWith(binding.root as  ViewGroup).setBlurRadius(25f)
                .setBlurEnabled(true)
                .setBlurAlgorithm(RenderScriptBlur(binding.root.context))
                .setBlurRadius(15f)
                .setHasFixedTransformationMatrix(true)
                .setBlurAutoUpdate(true)
        }
        binding.blurLike.apply {
            outlineProvider = ViewOutlineProvider.BACKGROUND
            clipToOutline = true
            setupWith(binding.root as  ViewGroup).setBlurRadius(25f)
                .setBlurEnabled(true)
                .setBlurAlgorithm(RenderScriptBlur(binding.root.context))
                .setBlurRadius(15f)
                .setHasFixedTransformationMatrix(true)
                .setBlurAutoUpdate(true)
        }



        return MovieHolder(binding)

    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class MovieHolder(
        private val binding: MovieItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        //binding image and rate  into the  movie item
        fun bind(movie: Result) {
            val image = "https://image.tmdb.org/t/p/w500/${movie.poster_path}"
            Log.e("Success",image)
            binding.pointText.text=movie.vote_average.toString()
            val options = RequestOptions()
            options.centerCrop()
            Glide.with(binding.root.context)
                .load(image)
                .fitCenter()
                .apply(options)
                .into(binding.moviePoster)




        }


    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem
        }
    }
}

