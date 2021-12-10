package com.example.marveldemo.data.network

import com.example.marveldemo.domain.model.RequestMarvel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("characters?ts=1")
    suspend fun getMarvelCharacter(@Query("apikey") apikey: String,
                                    @Query("hash") hash:String):RequestMarvel

    @GET("characters/{characterId}?ts=1")
    suspend fun getMarvelCharacterId(@Path("characterId") characterId: Int,
                                     @Query("apikey") apikey: String,
                                     @Query("hash") hash:String): Any
}