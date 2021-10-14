package com.mehmetalivargun.odev1.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mehmetalivargun.odev1.data.api.Result
import com.mehmetalivargun.odev1.data.api.ResultX
import com.mehmetalivargun.odev1.databinding.ActorItemBinding
import com.mehmetalivargun.odev1.databinding.MovieItemBinding


class ActorAdapter (): ListAdapter<ResultX, ActorAdapter.ActorHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val binding = ActorItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )

        return ActorHolder(binding)

    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ActorHolder(
        private val binding:  ActorItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(actor: ResultX) {
            val image = "https://image.tmdb.org/t/p/w500/${actor.profile_path}"
            Log.e("Success",image)
            binding.actorName.text=actor.name.replace(" ","\n")
            val options = RequestOptions()
            options.centerCrop()
            Glide.with(binding.root.context)
                .load(image)
                .fitCenter()
                .apply(options)
                .into(binding.actorImage)


        }


    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ResultX>() {
            override fun areItemsTheSame(oldItem: ResultX, newItem: ResultX) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ResultX, newItem: ResultX) =
                oldItem == newItem
        }
    }
}
