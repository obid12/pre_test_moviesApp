package com.obidia.moviesapp.data.repository

import com.obidia.moviesapp.data.api.ApiClient
import com.obidia.moviesapp.domain.entity.DetailMovieEntity
import com.obidia.moviesapp.domain.entity.MoviePopularEntity
import com.obidia.moviesapp.domain.entity.MovieTopRatedEntity
import com.obidia.moviesapp.domain.repo.Repository
import com.obidia.moviesapp.utils.result.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val apiClient: ApiClient
) : Repository {
    override suspend fun getDetailMovie(
        id: String,
        apiKey: String,
        language: String,
        trailer: String
    ): Flow<Resource<DetailMovieEntity>> {
        return flow {
            try {
                val response = apiClient.getDetailMovie(id, apiKey, language, trailer)
                delay(1000)
                if (response.isSuccessful) {
                    val body = response.body()?.toDetailMovieEntity()
                    emit(Resource.Success(body!!))
                } else {
                    emit(Resource.Error(response.message()))
                }
            } catch (e: IOException) {

                emit(Resource.Error("Network Failure"))

            }
        }
    }

    override suspend fun getMoviePopular(
        apiKey: String,
        language: String,
        page: Int
    ): Flow<Resource<MutableList<MoviePopularEntity>>> {
        return flow {
            try {
                val response = apiClient.getAllMoviePopuler(
                    apiKey, language, page
                )
                delay(1000)
                if (response.isSuccessful) {
                    val data = mutableListOf<MoviePopularEntity>()
                    val body = response.body()?.results
                    body?.forEach {
                        data.add(it?.toMoviePopularEntity()!!)
                    }
                    emit(Resource.Success(data))
                } else {

                    emit(Resource.Error(response.message()))

                }
            } catch (e: IOException) {

                emit(Resource.Error("Network Failure"))

            }


        }
    }

    override suspend fun getMovieTopRated(
        apiKey: String,
        language: String,
        page: Int
    ): Flow<Resource<MutableList<MovieTopRatedEntity>>> {
        return flow {
            try {
                val response = apiClient.getAllMovieTopRated(
                    apiKey, language, page
                )
                delay(1000)
                if (response.isSuccessful) {
                    val data = mutableListOf<MovieTopRatedEntity>()
                    val body = response.body()?.results
                    body?.forEach {
                        data.add(it?.toMovieTopRatedEntity()!!)
                    }
                    emit(Resource.Success(data))
                } else {

                    emit(Resource.Error(response.message()))

                }
            } catch (e: IOException) {

                emit(Resource.Error("Network Failure"))

            }


        }
    }
}