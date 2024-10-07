package com.example.a01710367examen.data.models

data class CharactersResponse(
    val items: List<DBCharacter>
)

data class DBCharacter(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String
)
