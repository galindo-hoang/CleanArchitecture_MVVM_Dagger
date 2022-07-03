package com.example.cleanarchitecturemvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturemvvm.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("delete from popular_movies")
    suspend fun deleteAllMovies()

    @Query("select * from popular_movies")
    suspend fun fetchMovies(): List<Movie>
}