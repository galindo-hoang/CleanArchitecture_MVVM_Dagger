package com.example.cleanarchitecturemvvm.data.repository.artist

import com.example.cleanarchitecturemvvm.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    // check suspend
    fun saveArtistsToDB(artists: List<Artist>)
    fun clearAll()
}