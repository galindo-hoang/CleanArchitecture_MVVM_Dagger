package com.example.cleanarchitecturemvvm.di.core

import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.artist.impl.ArtistCacheDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.movie.MovieCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.movie.impl.MovieCacheDataSourceImpl
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemvvm.data.repository.tvshow.impl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MovieCacheDataSource = MovieCacheDataSourceImpl()

    @Provides
    @Singleton
    fun provideArtistCacheDataSource(): ArtistCacheDataSource = ArtistCacheDataSourceImpl()

    @Provides
    @Singleton
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource = TvShowCacheDataSourceImpl()
}