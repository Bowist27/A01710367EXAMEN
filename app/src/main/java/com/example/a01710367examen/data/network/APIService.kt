package com.example.a01710367examen.data.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {
    @GET("endpoint")
    @Headers("Content-Type: application/json")
    suspend fun getSomething(
        @Query("parameter") parameter: String
    ): String // This shuld be modified
}