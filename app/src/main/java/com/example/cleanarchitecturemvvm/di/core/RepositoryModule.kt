package com.example.cleanarchitecturemvvm.di.core

import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistLocalDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistRepositoryImpl
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieLocalDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieRemoteDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieRepositoryImpl
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowLocalDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowRepositoryImpl
import com.example.cleanarchitecturemvvm.domain.repository.ArtistRepository
import com.example.cleanarchitecturemvvm.domain.repository.MovieRepository
import com.example.cleanarchitecturemvvm.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository =
        MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvShowRepository =
        TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ): ArtistRepository =
        ArtistRepositoryImpl(
            artistLocalDataSource,
            artistRemoteDataSource,
            artistCacheDataSource
        )
}