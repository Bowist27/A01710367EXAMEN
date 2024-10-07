package com.example.a01710367examen.data.network

class APIClient {
    private lateinit var api: APIService

    suspend fun getSomething(parameter: String): String? {
        api = NetworkModuleDI()
        return try {
            api.getSomething(parameter)
        } catch (e: Exception) { // Catch other exceptions
            e.printStackTrace()
            null
        }
    }

}