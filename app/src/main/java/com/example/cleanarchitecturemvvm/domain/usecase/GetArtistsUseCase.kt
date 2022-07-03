package com.example.cleanarchitecturemvvm.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun invoke(): List<Artist> = artistRepository.getArtists()
}