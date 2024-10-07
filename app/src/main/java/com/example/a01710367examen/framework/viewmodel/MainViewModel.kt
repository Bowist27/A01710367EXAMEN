package com.example.a01710367examen.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a01710367examen.data.models.DBCharacter
import com.example.a01710367examen.data.network.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val charactersLiveData = MutableLiveData<List<DBCharacter>>()
    private val repository = Repository()
    private val allCharacters = mutableListOf<DBCharacter>() // Lista de todos los personajes
    private var filteredCharacters = mutableListOf<DBCharacter>() // Lista de personajes filtrados

    fun getCharacters(limit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCharacters(limit)
            allCharacters.addAll(response.items) // Agregar nuevos personajes a la lista
            charactersLiveData.postValue(allCharacters) // Publicar la lista completa inicialmente
        }
    }

    // Función para filtrar por raza
    fun filterByRace(race: String) {
        filteredCharacters = allCharacters.filter { it.race == race }.toMutableList()
        charactersLiveData.postValue(filteredCharacters) // Publicar la lista filtrada
    }
}

