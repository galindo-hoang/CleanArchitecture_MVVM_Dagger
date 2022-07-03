package com.example.cleanarchitecturemvvm.domain.repository

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>
    suspend fun updateTvShows(): List<TvShow>
}