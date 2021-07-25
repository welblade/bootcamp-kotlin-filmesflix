package com.br.natanfc.filmesflix.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.natanfc.filmesflix.databinding.MovieItemLayoutBinding
import com.br.natanfc.filmesflix.domain.Movie

class MoviesAdapter(): RecyclerView.Adapter<MoviesViewHolder>() {
    private var moviesList: List<Movie> = listOf()
    var movieClickListener: (Int) -> Unit = { _ -> }
    private lateinit var itemBinding: MovieItemLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        itemBinding = MovieItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MoviesViewHolder(itemBinding)
    }
    fun setMovieList(moviesList: List<Movie>) {
        this.moviesList = moviesList
    }
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.apply {
            bind(movie)
            setClickListener {
                movieClickListener(movie.id)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size



}