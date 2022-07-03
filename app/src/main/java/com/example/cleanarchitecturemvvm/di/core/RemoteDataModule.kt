package com.example.cleanarchitecturemvvm.di.core

import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.impl.ArtistRemoteDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieRemoteDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.impl.MovieRemoteDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.impl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Provides
    @Singleton
    fun provideMovieRemoteDatasource(tmdbService: TMDBService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(tmdbService, apiKey)

    @Provides
    @Singleton
    fun provideTvShowRemoteDatasource(tmdbService: TMDBService): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(tmdbService, apiKey)

    @Provides
    @Singleton
    fun provideArtistRemoteDatasource(tmdbService: TMDBService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(tmdbService, apiKey)
}