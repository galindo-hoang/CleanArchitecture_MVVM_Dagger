package com.example.cleanarchitecturemvvm.data.repository.movie.impl

import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieCacheDataSource
import javax.inject.Inject

class MovieCacheDataSourceImpl constructor(): MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override fun getMoviesFromCache(): List<Movie> = movieList

    override fun saveMoviesToCache(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
}