package com.example.cleanarchitecturemvvm.di

import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.impl.ArtistCacheDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.impl.MovieCacheDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.impl.TvShowCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindTvShowCacheDataSource(
        tvShowCacheDataSourceImpl: TvShowCacheDataSourceImpl
    ): TvShowCacheDataSource

    @Binds
    abstract fun bindArtistCacheDataSource(
        artistCacheDataSourceImpl: ArtistCacheDataSourceImpl
    ): ArtistCacheDataSource

    @Binds
    abstract fun bindMovieCacheDataSource(
        movieCacheDataSourceImpl: MovieCacheDataSourceImpl
    ): MovieCacheDataSource
}