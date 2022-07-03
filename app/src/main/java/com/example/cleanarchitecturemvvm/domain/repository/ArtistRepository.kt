package com.example.cleanarchitecturemvvm.domain.repository

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturemvvm.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>
    suspend fun updateArtists(): List<Artist>
}