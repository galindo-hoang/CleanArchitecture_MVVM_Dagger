package com.example.cleanarchitecturemvvm.data.repository.artist.impl

import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private val artistList = mutableListOf<Artist>()
    override fun getArtistsFromCache(): List<Artist> = artistList

    override fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }
}