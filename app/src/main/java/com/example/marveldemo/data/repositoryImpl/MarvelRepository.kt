package com.example.marveldemo.data.repositoryImpl

import com.example.marveldemo.data.network.RetrofitService


class MarvelRepository(private val retrofit: RetrofitService) {
   suspend fun getMarvel(apikey: String, hash: String) = retrofit.getMarvelCharacter(apikey,hash)

   suspend fun getMarvelId(characterId: Int,apikey: String, hash: String) = retrofit.getMarvelCharacterId(characterId,apikey,hash)
}