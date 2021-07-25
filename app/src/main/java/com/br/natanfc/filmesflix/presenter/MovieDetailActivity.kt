package com.br.natanfc.filmesflix.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.br.natanfc.filmesflix.R
import com.br.natanfc.filmesflix.databinding.ActivityMovieDetailBinding
import com.br.natanfc.filmesflix.domain.Movie
import com.br.natanfc.filmesflix.framework.viewmodel.MovieDetailViewModel

class MovieDetailActivity : AppCompatActivity() {
    private val movieDetailBinding: ActivityMovieDetailBinding by lazy {
        ActivityMovieDetailBinding.inflate(layoutInflater)
    }
    private val id: Int by lazy {
        intent.getIntExtra("id", -1)
    }
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(movieDetailBinding.root)
        movieDetailViewModel = ViewModelProvider.NewInstanceFactory()
            .create(MovieDetailViewModel::class.java)
        movieDetailViewModel.init(id)
        initObserver()
    }

    private fun setValues(movie: Movie){
        movieDetailBinding.apply {
            ivImage.load(movie.imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
            tvReleaseDate.text = movie.dataLancamento
            tvTitle.text = movie.titulo
            tvDescription.text = movie.descricao
        }

    }
    private fun initObserver() {
        movieDetailViewModel.movie.observe(this, { movie ->
            movie?.let{
                setValues(it)
            }
        })
    }

}