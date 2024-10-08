package com.muratcay.beinconnecttestcase.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muratcay.beinconnecttestcase.databinding.RowMoviesCategoriesBinding
import com.muratcay.beinconnecttestcase.utils.Resource
import com.muratcay.remote.models.Movie
import javax.inject.Inject

class MoviesCategoriesAdapter @Inject constructor() : RecyclerView.Adapter<MoviesCategoriesAdapter.ViewHolder>() {

    private var onMovieClickListener: ((Movie) -> Unit)? = null
    private var onCategoryClickListener: ((String) -> Unit)? = null

    private val diffUtil = object : DiffUtil.ItemCallback<Resource<Any>>() {
        override fun areItemsTheSame(oldItem: Resource<Any>, newItem: Resource<Any>): Boolean {
            return oldItem.data == newItem.data
        }

        override fun areContentsTheSame(oldItem: Resource<Any>, newItem: Resource<Any>): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)
    var list: List<Resource<Any>>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    fun setOnMovieClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

    fun setOnCategoryClickListener(listener: (String) -> Unit) {
        onCategoryClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowMoviesCategoriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentResource = list[position]
        holder.bind(currentResource)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: RowMoviesCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(resource: Resource<Any>) {
            binding.rowMoviesCategoriesTitle.text = resource.title
            when (resource) {
                is Resource.Success -> {
                    val moviesAdapter = MoviesAdapter()
                    binding.rowMoviesCategoriesRv.apply {
                        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                        adapter = moviesAdapter
                    }
                    moviesAdapter.apply {
                        list = resource.data as List<Movie>
                        setOnMovieClickListener { movie ->
                            onMovieClickListener?.invoke(movie)
                        }
                    }
                }

                else -> {}
            }

            binding.root.setOnClickListener {
                onCategoryClickListener?.invoke(resource.title ?: "")
            }
        }
    }
}