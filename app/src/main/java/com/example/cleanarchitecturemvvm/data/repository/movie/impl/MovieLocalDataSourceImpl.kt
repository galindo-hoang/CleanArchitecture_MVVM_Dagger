package com.example.cleanarchitecturemvvm.data.repository.movie.impl

import com.example.cleanarchitecturemvvm.data.dao.MovieDao
import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
): MovieLocalDataSource {
    // room execute getData from background thread
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.fetchMovies()
    override fun saveMoviesToDB(movies: List<Movie>){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }
    override fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}