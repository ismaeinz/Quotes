package com.example.quotes.di

import com.example.quotes.data.remote.ApiInterface
import com.example.quotes.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object NetworkModel {
    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseUrl(): String = BASE_URL


    @Singleton
    @Provides
    fun getRetroFitClient(
        @Named("base_url") baseUrl:String
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun getApiClient(
        retrofit: Retrofit
    ): ApiInterface = retrofit.create(ApiInterface::class.java)

}