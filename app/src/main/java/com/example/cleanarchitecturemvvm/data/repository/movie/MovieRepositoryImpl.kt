package com.example.cleanarchitecturemvvm.data.repository.movie

import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl constructor(
    private val movieRemoteDatasource: MovieRemoteDataSource,
    private val movieLocalDatasource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
): MovieRepository {
    override suspend fun getMovies(): List<Movie> = getMovieFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        var movieList:List<Movie> = listOf()
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.results
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie>{
        var movieList: List<Movie> = listOf()
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return movieList.ifEmpty {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
            movieList
        }
    }

    private suspend fun getMovieFromCache(): List<Movie>{
        var movieList: List<Movie> = listOf()
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return movieList.ifEmpty {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
            movieList
        }
    }
}