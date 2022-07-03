package com.example.cleanarchitecturemvvm.data.repository.artist

import com.example.cleanarchitecturemvvm.data.model.artist.Artist

interface ArtistCacheDataSource {
    // check suspend
    fun getArtistsFromCache(): List<Artist>
    fun saveArtistsToCache(artists: List<Artist>)
}