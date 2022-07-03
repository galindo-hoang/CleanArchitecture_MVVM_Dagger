package com.example.cleanarchitecturemvvm.data.api

import com.example.cleanarchitecturemvvm.data.model.artist.ArtistList
import com.example.cleanarchitecturemvvm.data.model.movie.MovieList
import com.example.cleanarchitecturemvvm.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey:String,
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query("api_key") apikey:String,
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apikey:String,
    ): Response<ArtistList>
}