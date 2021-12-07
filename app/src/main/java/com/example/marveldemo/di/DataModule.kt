package com.example.marveldemo.di

import com.example.marveldemo.data.network.RetrofitService
import com.example.marveldemo.data.repositoryImpl.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun providesMarvelRespository(retrofitService: RetrofitService): MarvelRepository{
        return MarvelRepository(retrofitService)
    }
}