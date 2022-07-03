package com.example.cleanarchitecturemvvm.data.repository.tvshow

import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    // check suspend
    fun getShowsFromCache(): List<TvShow>
    fun saveShowsToCache(movies: List<TvShow>)
}