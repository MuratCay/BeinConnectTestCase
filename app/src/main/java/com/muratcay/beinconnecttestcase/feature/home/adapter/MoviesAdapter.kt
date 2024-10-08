package com.muratcay.beinconnecttestcase.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muratcay.beinconnecttestcase.databinding.RowFragmentMoviesBinding
import com.muratcay.beinconnecttestcase.extensions.loadImage
import com.muratcay.remote.models.Movie
import javax.inject.Inject

class MoviesAdapter @Inject constructor() : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var onMovieClickListener: ((Movie) -> Unit)? = null

    private val diffUtil = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)
    var list: List<Movie>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    fun setOnMovieClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowFragmentMoviesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = list[position]
        holder.bind(currentMovie)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: RowFragmentMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.rowFragmentMoviesImage.apply {
                contentDescription = movie.title
                loadImage(movie.image)
            }
            binding.rowFragmentMoviesName.text = movie.title

            binding.root.setOnClickListener {
                onMovieClickListener?.invoke(movie)
            }
        }
    }
}