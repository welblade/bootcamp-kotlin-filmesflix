package com.br.natanfc.filmesflix.usecase

import com.br.natanfc.filmesflix.data.MovieRepository

class MovieDetailUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(id: Int) = movieRepository.getMovieByIdFromDataSource(id)
}