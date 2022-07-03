package com.example.cleanarchitecturemvvm.data.repository.tvshow.impl

import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private val tvShowList = arrayListOf<TvShow>()
    override fun getShowsFromCache(): List<TvShow> = tvShowList

    override fun saveShowsToCache(movies: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(movies)
    }
}