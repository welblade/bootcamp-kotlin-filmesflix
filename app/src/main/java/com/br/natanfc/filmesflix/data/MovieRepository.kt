package com.br.natanfc.filmesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
    fun getMovieByIdFromDataSource(id:Int) = movieDataSource.getMovieById(id)

}