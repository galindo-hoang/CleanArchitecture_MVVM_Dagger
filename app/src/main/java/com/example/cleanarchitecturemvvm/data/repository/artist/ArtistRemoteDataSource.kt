package com.example.cleanarchitecturemvvm.data.repository.artist

import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}