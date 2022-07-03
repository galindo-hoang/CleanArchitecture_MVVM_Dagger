package com.example.cleanarchitecturemvvm.data.repository.tvshow.impl

import com.example.cleanarchitecturemvvm.dao.TvShowDao
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.data.repository.tvshow.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowLocalDataSourceImpl @Inject constructor(
    private val tvShowDao: TvShowDao
): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDatabase(): List<TvShow> = tvShowDao.fetchTvShows()

    override fun saveTvShowsToDatabase(movies: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(movies)
        }
    }

    override fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}