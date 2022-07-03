package com.example.cleanarchitecturemvvm.di.movie

import com.example.cleanarchitecturemvvm.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateMoviesUseCase
import com.example.cleanarchitecturemvvm.presentation.movie.MovieViewModel
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModel.MovieViewModelFactory =
        MovieViewModel.MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase,
        )
}