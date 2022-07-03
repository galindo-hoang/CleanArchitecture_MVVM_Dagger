package com.example.cleanarchitecturemvvm.data.repository.movie

import com.example.cleanarchitecturemvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}