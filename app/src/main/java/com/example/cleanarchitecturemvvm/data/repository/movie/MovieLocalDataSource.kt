package com.example.cleanarchitecturemvvm.data.repository.movie

import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    // check suspend
    fun saveMoviesToDB(movies: List<Movie>)
    fun clearAll()
}