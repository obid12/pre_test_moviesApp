package com.obidia.moviesapp.data.response.populer


import com.google.gson.annotations.SerializedName
import com.obidia.moviesapp.domain.entity.MoviePopularEntity

data class MoviePopularResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<ResultPopular?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)