package com.example.cleanarchitecturemvvm.data.repository.artist.impl

import com.example.cleanarchitecturemvvm.data.dao.ArtistDao
import com.example.cleanarchitecturemvvm.data.model.artist.Artist
import com.example.cleanarchitecturemvvm.data.repository.artist.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistLocalDataSourceImpl @Inject constructor(
    private val artistDao: ArtistDao
): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.fetchArtists()

    override fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveMovies(artists)
        }
    }

    override fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}