package com.example.a01710367examen.data.models

data class CharactersResponse(
    val items: List<DBCharacter>
)

data class DBCharacter(
    val id: Int,
    val name: String,
    val ki: String, // Añadir ki
    val maxKi: String, // Añadir maxKi
    val race: String, // Añadir race
    val gender: String, // Añadir gender
    val description: String, // Añadir description
    val image: String
)
