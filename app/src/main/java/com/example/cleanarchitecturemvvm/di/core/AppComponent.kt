package com.example.cleanarchitecturemvvm.di.core

import com.example.cleanarchitecturemvvm.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemvvm.di.movie.MovieSubComponent
import com.example.cleanarchitecturemvvm.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityModule::class,
    ApplicationModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    UseCaseModule::class,
    RepositoryModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}