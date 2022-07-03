package com.example.cleanarchitecturemvvm.data.repository.tvshow.impl

import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShowList
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTVShows(apiKey)
}