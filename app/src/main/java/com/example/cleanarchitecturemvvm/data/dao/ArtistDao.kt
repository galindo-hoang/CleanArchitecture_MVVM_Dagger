package com.example.cleanarchitecturemvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturemvvm.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<Artist>)

    @Query("delete from popular_artists")
    suspend fun deleteAllArtists()

    @Query("select * from popular_artists")
    suspend fun fetchArtists(): List<Artist>
}