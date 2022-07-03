package com.example.cleanarchitecturemvvm.domain.usecase

import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun invoke(): List<TvShow> = tvShowRepository.updateTvShows()
}