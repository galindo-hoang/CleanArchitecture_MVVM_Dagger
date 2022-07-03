package com.example.cleanarchitecturemvvm.data.repository.movie.impl

import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.model.movie.MovieList
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}