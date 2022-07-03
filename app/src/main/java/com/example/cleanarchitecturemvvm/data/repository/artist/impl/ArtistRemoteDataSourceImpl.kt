package com.example.cleanarchitecturemvvm.data.repository.artist.impl

import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.model.artist.ArtistList
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemvvm.di.annotation.ApiKey
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    @ApiKey
    private val apiKey: String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}