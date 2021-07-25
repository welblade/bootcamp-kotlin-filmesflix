package com.br.natanfc.filmesflix.presenter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.br.natanfc.filmesflix.R
import com.br.natanfc.filmesflix.databinding.MovieItemLayoutBinding
import com.br.natanfc.filmesflix.domain.Movie

class MoviesViewHolder(private val item: MovieItemLayoutBinding) : RecyclerView.ViewHolder(item.root){
    fun bind(movie: Movie) {
        item.apply {
            movieTitle.text = movie.titulo
            movieImage.load(movie.imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }
}