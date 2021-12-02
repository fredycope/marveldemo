package com.example.marveldemo.domain.usecase

import com.example.marveldemo.data.repositoryImpl.MarvelRepository
import com.example.marveldemo.domain.model.RequestMarvel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMarvelUseCase (private val repository: MarvelRepository){
    suspend fun invoke(apikey: String, hash: String): RequestMarvel = withContext(Dispatchers.IO){
        repository.getMarvel(apikey, hash)
    }


}