package com.example.cleanarchitecturemvvm.domain.usecase

import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun invoke(): List<Artist> = artistRepository.updateArtists()
}