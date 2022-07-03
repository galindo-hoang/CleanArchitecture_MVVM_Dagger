package com.example.cleanarchitecturemvvm.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.cleanarchitecturemvvm.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateTvShowsUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class TvShowViewModel @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
): ViewModel() {
    fun getTvShows() = liveData {
        emit(getTvShowsUseCase.invoke())
    }

    fun updateTvShows() = liveData {
        emit(updateTvShowsUseCase.invoke())
    }

//    class TvShowViewModelFactory(
//        private val getTvShowsUseCase: GetTvShowsUseCase,
//        private val updateTvShowsUseCase: UpdateTvShowsUseCase,
//    ): ViewModelProvider.Factory{
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            if(modelClass.isAssignableFrom(TvShowViewModel::class.java)){
//                return TvShowViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
//            }
//            throw IllegalArgumentException("Unknown TvShowViewModel class")
//        }
//    }
}