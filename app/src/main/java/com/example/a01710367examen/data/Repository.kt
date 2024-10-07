package com.example.a01710367examen.data.network

import com.example.a01710367examen.data.models.CharactersResponse
import com.example.a01710367examen.data.models.DBCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository {
    private val api = APIClient()

    suspend fun getSomething(parameter: String) = api.getSomething(parameter)
}
