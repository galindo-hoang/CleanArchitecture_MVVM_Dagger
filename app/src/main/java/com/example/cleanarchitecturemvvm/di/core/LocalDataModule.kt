package com.example.cleanarchitecturemvvm.di.core

import com.example.cleanarchitecturemvvm.dao.TvShowDao
import com.example.cleanarchitecturemvvm.data.dao.ArtistDao
import com.example.cleanarchitecturemvvm.data.dao.MovieDao
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistLocalDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.impl.ArtistLocalDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieLocalDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.impl.MovieLocalDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowLocalDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.impl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)

    @Provides
    @Singleton
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource =
        TvShowLocalDataSourceImpl(tvShowDao)

    @Provides
    @Singleton
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDao)
}