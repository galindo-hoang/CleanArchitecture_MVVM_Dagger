package com.example.cleanarchitecturemvvm.data.repository.artist

import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.domain.repository.ArtistRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistRepositoryImpl @Inject constructor(
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist> = getArtistFromCache()

    override suspend fun updateArtists(): List<Artist> {
        val artistsList = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(artistsList)
        artistCacheDataSource.saveArtistsToCache(artistsList)
        return artistsList
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        var artistsList = listOf<Artist>()
        try {
            val body = artistRemoteDataSource.getArtists().body()
            if(body != null) artistsList = body.results
        }catch (e:Exception){
            e.printStackTrace()
        }
        return artistsList
    }

    private suspend fun getArtistFromDB(): List<Artist>{
        var artistsList = listOf<Artist>()
        try {
            artistsList = artistLocalDataSource.getArtistsFromDB()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return artistsList.ifEmpty {
            artistsList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistsList)
            artistsList
        }
    }

    private suspend fun getArtistFromCache(): List<Artist>{
        var artistsList = listOf<Artist>()
        try {
            artistsList = artistCacheDataSource.getArtistsFromCache()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return artistsList.ifEmpty {
            artistsList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistsList)
            artistsList
        }
    }
}