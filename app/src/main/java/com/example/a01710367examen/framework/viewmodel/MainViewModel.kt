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

    fun getCharacters(limit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCharacters(limit)
            charactersLiveData.postValue(response.items)
        }
    }
}
