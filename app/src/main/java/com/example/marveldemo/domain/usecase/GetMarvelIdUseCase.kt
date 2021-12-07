package com.example.marveldemo.domain.usecase

import com.example.marveldemo.data.repositoryImpl.MarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMarvelIdUseCase (private val repository: MarvelRepository) {
    suspend fun invoke(characterId: Int,apikey: String, hash: String): Any = withContext(Dispatchers.IO){
        repository.getMarvelId(characterId, apikey, hash)
    }
}