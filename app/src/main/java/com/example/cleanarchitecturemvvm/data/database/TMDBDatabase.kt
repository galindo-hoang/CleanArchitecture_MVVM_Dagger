package com.example.cleanarchitecturemvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturemvvm.data.dao.ArtistDao
import com.example.cleanarchitecturemvvm.data.dao.MovieDao
import com.example.cleanarchitecturemvvm.dao.TvShowDao
import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.data.model.movie.Movie
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}