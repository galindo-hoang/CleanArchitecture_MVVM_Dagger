package com.example.cleanarchitecturemvvm.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitecturemvvm.BuildConfig
import com.example.cleanarchitecturemvvm.dao.TvShowDao
import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.dao.*
import com.example.cleanarchitecturemvvm.data.database.TMDBDatabase
import com.example.cleanarchitecturemvvm.data.repository.artist.*
import com.example.cleanarchitecturemvvm.data.repository.artist.impl.*
import com.example.cleanarchitecturemvvm.data.repository.movie.*
import com.example.cleanarchitecturemvvm.data.repository.movie.impl.*
import com.example.cleanarchitecturemvvm.data.repository.tvshow.*
import com.example.cleanarchitecturemvvm.data.repository.tvshow.impl.*
import com.example.cleanarchitecturemvvm.di.annotation.*
import com.example.cleanarchitecturemvvm.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule{

    @Provides
    @Singleton
    @BaseURL
    fun provideBaseURL() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    @ApiKey
    fun provideApiKey() = BuildConfig.API_KEY

    @Provides
    @Singleton
    fun provideTMDBService(retrofit: Retrofit): TMDBService =
        retrofit.create(TMDBService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(@BaseURL BASE_URL: String): Retrofit =
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun provideTMDBDatabase(
        @ApplicationContext context: Context,
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



    @Provides
    fun providesArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository =
        ArtistRepositoryImpl(
            artistLocalDataSource,
            artistRemoteDataSource,
            artistCacheDataSource
        )



    @Provides
    fun providesTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository =
        TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository =
        MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource,
        )

    @Provides
    fun providesMovieRemoteDataSource(
        tmdbService: TMDBService,
        @ApiKey
        apiKey: String,
    ): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(tmdbService,apiKey)

    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)

    @Provides
    fun providesArtistRemoteDataSource(
        tmdbService: TMDBService,
        @ApiKey
        apiKey: String,
    ): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(tmdbService,apiKey)

    @Provides
    fun providesArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDao)

    @Provides
    fun providesTvShowRemoteDataSource(
        tmdbService: TMDBService,
        @ApiKey
        apiKey: String,
    ): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(tmdbService,apiKey)

    @Provides
    fun providesTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource =
        TvShowLocalDataSourceImpl(tvShowDao)
}