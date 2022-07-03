package com.example.cleanarchitecturemvvm.di

import com.example.cleanarchitecturemvvm.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemvvm.di.movie.MovieSubComponent
import com.example.cleanarchitecturemvvm.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}