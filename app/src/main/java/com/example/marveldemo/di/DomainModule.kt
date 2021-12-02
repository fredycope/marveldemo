package com.example.marveldemo.di

import com.example.marveldemo.data.repositoryImpl.MarvelRepository
import com.example.marveldemo.domain.usecase.GetMarvelIdUseCase
import com.example.marveldemo.domain.usecase.GetMarvelUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun providesMarvel(repository: MarvelRepository): GetMarvelUseCase{
        return GetMarvelUseCase(repository)
    }

    @Provides
    fun providesMarvelId(repository: MarvelRepository): GetMarvelIdUseCase{
        return  GetMarvelIdUseCase(repository)
    }
}