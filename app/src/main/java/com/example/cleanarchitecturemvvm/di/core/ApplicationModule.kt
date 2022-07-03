package com.example.cleanarchitecturemvvm.di.core

import android.content.Context
import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemvvm.di.movie.MovieSubComponent
import com.example.cleanarchitecturemvvm.di.tvshow.TvShowSubComponent
import com.example.cleanarchitecturemvvm.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    ArtistSubComponent::class,
    TvShowSubComponent::class
])
class ApplicationModule(
    private val context: Context,
    private val baseURL: String
) {

    @Provides
    @Singleton
    fun provideBaseActivity(): Context =
        context.applicationContext

    @Provides
    @Singleton
    fun provideTMDBService(retrofit: Retrofit): TMDBService =
        retrofit.create(TMDBService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()
}