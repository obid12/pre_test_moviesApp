package com.obidia.moviesapp.data.response.detail


import com.google.gson.annotations.SerializedName

data class Videos(
    @SerializedName("results")
    val results: List<Result?>?
)