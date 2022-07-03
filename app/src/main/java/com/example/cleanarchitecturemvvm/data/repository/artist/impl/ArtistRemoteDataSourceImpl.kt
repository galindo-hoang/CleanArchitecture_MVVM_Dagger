package com.example.cleanarchitecturemvvm.data.repository.artist.impl

import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.data.model.artist.ArtistList
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}