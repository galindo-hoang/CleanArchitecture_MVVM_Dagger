package com.example.cleanarchitecturemvvm.di.core

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitecturemvvm.dao.TvShowDao
import com.example.cleanarchitecturemvvm.data.dao.ArtistDao
import com.example.cleanarchitecturemvvm.data.dao.MovieDao
import com.example.cleanarchitecturemvvm.data.database.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideTMDBDatabase(
        /*@ApplicationContext*/context: Context,
    ): TMDBDatabase =
        Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,"TMDBDatabase"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideMovieDao(TMDBDatabase: TMDBDatabase): MovieDao = TMDBDatabase.movieDao()

    @Provides
    @Singleton
    fun provideTvShowDao(TMDBDatabase: TMDBDatabase): TvShowDao = TMDBDatabase.tvShowDao()

    @Provides
    @Singleton
    fun provideArtistDao(TMDBDatabase: TMDBDatabase): ArtistDao = TMDBDatabase.artistDao()
}