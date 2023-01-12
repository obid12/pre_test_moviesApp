package com.obidia.moviesapp.utils.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit(okHttp: OkHttpClient, @ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            client(
                okHttp.newBuilder().addInterceptor(
                    ChuckerInterceptor.Builder(context)
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                ).build()
            )
            baseUrl("https://api.themoviedb.org/")
        }.build()
    }

    @Singleton
    @Provides
    fun provideOkHttp(logging: HttpLoggingInterceptor): OkHttpClient {
        logging.apply {
            logging.level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            addInterceptor(logging)
        }.build()
    }


}