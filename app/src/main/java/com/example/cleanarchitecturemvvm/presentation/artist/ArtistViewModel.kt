package com.example.cleanarchitecturemvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.cleanarchitecturemvvm.domain.usecase.GetArtistsUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateArtistsUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ArtistViewModel @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
): ViewModel() {
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.invoke()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.invoke()
        emit(artistList)
    }

//    class ArtistViewModelFactory(
//        private val getArtistsUseCase: GetArtistsUseCase,
//        private val updateArtistsUseCase: UpdateArtistsUseCase,
//    ): ViewModelProvider.Factory{
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            if(modelClass.isAssignableFrom(ArtistViewModel::class.java)){
//                return ArtistViewModel(getArtistsUseCase,updateArtistsUseCase) as T
//            }
//            throw IllegalArgumentException("Unknown ArtistViewModel class")
//        }
//
//    }
}