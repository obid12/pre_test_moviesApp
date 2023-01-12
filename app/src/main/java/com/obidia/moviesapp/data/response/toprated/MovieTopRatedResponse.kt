package com.obidia.moviesapp.data.response.toprated


import com.google.gson.annotations.SerializedName

data class MovieTopRatedResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<ResultTopRated?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)