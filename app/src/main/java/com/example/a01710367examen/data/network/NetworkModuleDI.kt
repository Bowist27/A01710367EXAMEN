package com.example.a01710367examen.data.network

object NetworkModuleDI {

    fun provideAPIService(): APIService {
        return APIClient.getClient().create(APIService::class.java)
    }
}
