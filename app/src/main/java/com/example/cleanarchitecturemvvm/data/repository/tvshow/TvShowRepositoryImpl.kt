package com.example.cleanarchitecturemvvm.data.repository.tvshow

import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShow
import com.example.cleanarchitecturemvvm.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDatabase(newListOfTvShow)
        tvShowCacheDataSource.saveShowsToCache(newListOfTvShow)
        return newListOfTvShow
    }

    private suspend fun getTvShowFromAPI(): List<TvShow>{
        var tvShowList = listOf<TvShow>()
        try {
            val body = tvShowRemoteDataSource.getTvShows().body()
            if (body != null) {
                tvShowList = body.results
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return tvShowList
    }

    private suspend fun getTvShowFromDB(): List<TvShow>{
        var tvShowList = listOf<TvShow>()
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDatabase()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return tvShowList.ifEmpty {
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowsToDatabase(tvShowList)
            tvShowList
        }
    }

    private suspend fun getTvShowsFromCache(): List<TvShow>{
        var tvShowList = listOf<TvShow>()
        try {
            tvShowList = tvShowCacheDataSource.getShowsFromCache()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return tvShowList.ifEmpty {
            tvShowList = getTvShowFromDB()
            tvShowLocalDataSource.saveTvShowsToDatabase(tvShowList)
            tvShowList
        }
    }

}