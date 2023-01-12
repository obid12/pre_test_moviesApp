package com.obidia.moviesapp.data.api

import com.obidia.moviesapp.data.response.detail.DetailMovieResponse
import com.obidia.moviesapp.data.response.populer.MoviePopularResponse
import com.obidia.moviesapp.data.response.toprated.MovieTopRatedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("/3/movie/popular")
    fun getAllMoviePopuler(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviePopularResponse>

    @GET("/3/movie/top_rated")
    fun getAllMovieTopRated(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MovieTopRatedResponse>

    @GET("/3/movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id: String,
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("append_to_response") video: String,
    ): Response<DetailMovieResponse>
}