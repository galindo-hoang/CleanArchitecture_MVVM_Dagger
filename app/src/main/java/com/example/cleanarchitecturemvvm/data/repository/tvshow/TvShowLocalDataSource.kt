package com.example.cleanarchitecturemvvm.data.repository.tvshow

import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDatabase(): List<TvShow>
    // check suspend
    fun saveTvShowsToDatabase(movies: List<TvShow>)
    fun clearAll()
}