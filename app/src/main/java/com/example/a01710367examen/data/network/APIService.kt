package com.example.a01710367examen.data.network

import com.example.a01710367examen.data.models.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("characters")
    suspend fun getCharacters(@Query("limit") limit: Int): CharactersResponse
}
