package com.br.natanfc.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.data.MovieRepository
import com.br.natanfc.filmesflix.domain.Movie
import com.br.natanfc.filmesflix.framework.api.MovieRestApiTask
import com.br.natanfc.filmesflix.implementations.MovieDataSourceImplementation
import com.br.natanfc.filmesflix.usecase.MovieDetailUseCase

class MovieDetailViewModel() : ViewModel() {
    companion object {
        const val TAG = "MovieRepository"
    }
    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieDetailUseCase = MovieDetailUseCase(movieRepository)

    private var _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie

    fun init(id: Int){
        getMovie(id)
    }

    private fun getMovie(id:Int) {
        Thread {
            try {
                _movie.postValue(movieDetailUseCase.invoke(id))
            } catch (exception: Exception) {
                Log.d(MovieListViewModel.TAG, exception.message.toString())
            }
        }.start()
    }
}