package com.example.cleanarchitecturemvvm.domain.usecase

import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.domain.repository.TvShowRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateTvShowsUseCase @Inject constructor(private val tvShowRepository: TvShowRepository) {
    suspend fun invoke(): List<TvShow> = tvShowRepository.updateTvShows()
}