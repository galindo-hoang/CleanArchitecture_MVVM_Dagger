package com.example.cleanarchitecturemvvm.domain.repository

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturemvvm.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun updateMovies(): List<Movie>
}