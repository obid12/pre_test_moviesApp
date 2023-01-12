package com.obidia.moviesapp.domain.repo

import com.obidia.moviesapp.domain.entity.DetailMovieEntity
import com.obidia.moviesapp.domain.entity.MoviePopularEntity
import com.obidia.moviesapp.domain.entity.MovieTopRatedEntity
import com.obidia.moviesapp.utils.result.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getDetailMovie(
        id: String, apiKey: String, language: String, trailer: String
    ): Flow<Resource<DetailMovieEntity>>

    suspend fun getMoviePopular(
        apiKey: String, language: String, page: Int
    ): Flow<Resource<MutableList<MoviePopularEntity>>>

    suspend fun getMovieTopRated(
        apiKey: String, language: String, page: Int
    ): Flow<Resource<MutableList<MovieTopRatedEntity>>>

}