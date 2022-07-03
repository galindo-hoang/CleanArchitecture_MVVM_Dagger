package com.example.cleanarchitecturemvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movie: List<TvShow>)

    @Query("delete from popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("select * from popular_tvShows")
    suspend fun fetchTvShows(): List<TvShow>
}