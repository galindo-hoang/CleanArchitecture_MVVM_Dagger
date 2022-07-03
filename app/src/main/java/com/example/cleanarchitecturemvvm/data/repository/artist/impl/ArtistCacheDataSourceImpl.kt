package com.example.cleanarchitecturemvvm.data.repository.artist.impl

import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistCacheDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistCacheDataSourceImpl @Inject constructor(): ArtistCacheDataSource {
    private val artistList = mutableListOf<Artist>()
    override fun getArtistsFromCache(): List<Artist> = artistList

    override fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }
}