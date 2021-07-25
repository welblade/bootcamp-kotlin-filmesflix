package com.br.natanfc.filmesflix.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.natanfc.filmesflix.databinding.MovieItemLayoutBinding
import com.br.natanfc.filmesflix.domain.Movie

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {
    private lateinit var itemBinding: MovieItemLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        itemBinding = MovieItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MoviesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int = moviesList.size



}