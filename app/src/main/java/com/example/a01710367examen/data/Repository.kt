package com.example.a01710367examen.data.network

import com.example.a01710367examen.data.models.CharactersResponse

class Repository {
    private val apiService = NetworkModuleDI.provideAPIService()

    suspend fun getCharacters(limit: Int): CharactersResponse {
        return apiService.getCharacters(limit)
    }
}
