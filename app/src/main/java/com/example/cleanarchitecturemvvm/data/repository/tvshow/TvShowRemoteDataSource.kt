package com.example.cleanarchitecturemvvm.data.repository.tvshow

import com.example.cleanarchitecturemvvm.data.model.movie.MovieList
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}