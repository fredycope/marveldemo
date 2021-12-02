package com.example.marveldemo.di

import com.example.marveldemo.data.network.RetrofitService
import com.example.marveldemo.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun providesService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}