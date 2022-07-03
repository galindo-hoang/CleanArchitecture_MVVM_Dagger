package com.example.cleanarchitecturemvvm.di.tvshow

import com.example.cleanarchitecturemvvm.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateMoviesUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateTvShowsUseCase
import com.example.cleanarchitecturemvvm.presentation.movie.MovieViewModel
import com.example.cleanarchitecturemvvm.presentation.tvshow.TvShowViewModel
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModel.TvShowViewModelFactory =
        TvShowViewModel.TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase,
        )
}