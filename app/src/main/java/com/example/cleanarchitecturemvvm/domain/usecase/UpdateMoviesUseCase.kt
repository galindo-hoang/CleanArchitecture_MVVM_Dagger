package com.example.cleanarchitecturemvvm.domain.usecase

import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend fun invoke(): List<Movie> = movieRepository.updateMovies()
}