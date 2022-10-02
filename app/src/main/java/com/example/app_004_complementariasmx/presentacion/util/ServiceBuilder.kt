package com.example.app_004_complementariasmx.presentacion.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {


    private fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttpClient())
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}