package com.example.cleanarchitecturemvvm.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase constructor(
    private val movieRepository: MovieRepository,
) {
    suspend fun invoke(): List<Movie> = movieRepository.getMovies()
}