package com.example.cleanarchitecturemvvm.data.repository.movie

import com.example.cleanarchitecturemvvm.data.model.movie.Movie

interface MovieCacheDataSource {
    // check suspend
    fun getMoviesFromCache(): List<Movie>
    fun saveMoviesToCache(movies: List<Movie>)
}