package com.example.cleanarchitecturemvvm.presentation

import android.app.Application
import com.example.cleanarchitecturemvvm.BuildConfig
import com.example.cleanarchitecturemvvm.di.Injector
import com.example.cleanarchitecturemvvm.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemvvm.di.core.*
import com.example.cleanarchitecturemvvm.di.movie.MovieSubComponent
import com.example.cleanarchitecturemvvm.di.tvshow.TvShowSubComponent

class BaseApplication: Application() , Injector{
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(applicationContext,BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent =
        appComponent.movieSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent =
        appComponent.tvShowSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponent =
        appComponent.artistSubComponent().create()
}