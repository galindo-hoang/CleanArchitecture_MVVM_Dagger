package com.example.cleanarchitecturemvvm.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.cleanarchitecturemvvm.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateMoviesUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MovieViewModel constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.invoke()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.invoke()
        emit(movieList)
    }

    class MovieViewModelFactory constructor(
        private val getMoviesUseCase: GetMoviesUseCase,
        private val updateMovieUseCase: UpdateMoviesUseCase,
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MovieViewModel::class.java)){
                return MovieViewModel(getMoviesUseCase,updateMovieUseCase) as T
            }
            throw IllegalArgumentException("Unknown MovieViewModel class")
        }

    }
}