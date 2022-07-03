package com.example.cleanarchitecturemvvm.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.domain.repository.ArtistRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetArtistsUseCase @Inject constructor(private val artistRepository: ArtistRepository) {
    suspend fun invoke(): List<Artist> = artistRepository.getArtists()
}