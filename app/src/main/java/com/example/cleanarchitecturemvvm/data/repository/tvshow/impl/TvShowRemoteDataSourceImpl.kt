package com.example.cleanarchitecturemvvm.data.repository.tvshow.impl

import com.example.cleanarchitecturemvvm.data.api.TMDBService
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShowList
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemvvm.di.annotation.ApiKey
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    @ApiKey
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTVShows(apiKey)
}