package com.example.cleanarchitecturemvvm.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvShows")
data class TvShow(
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
)