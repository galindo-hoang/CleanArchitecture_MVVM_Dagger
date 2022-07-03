package com.example.cleanarchitecturemvvm.domain.usecase

import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.domain.repository.ArtistRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateArtistsUseCase @Inject constructor(private val artistRepository: ArtistRepository) {
    suspend fun invoke(): List<Artist> = artistRepository.updateArtists()
}