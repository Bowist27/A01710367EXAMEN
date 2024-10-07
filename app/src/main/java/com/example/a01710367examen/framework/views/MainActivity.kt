package com.example.a01710367examen.framework.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a01710367examen.data.models.DBCharacter
import com.example.a01710367examen.databinding.ActivityMainBinding
import com.example.a01710367examen.framework.adapter.CharactersAdapter
import com.example.a01710367examen.framework.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setupRecyclerView()
        setupObservers()

        viewModel.getCharacters(10) // Llamada para obtener los personajes
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        adapter = CharactersAdapter { character ->
            openCharacterDetail(character) // Abrir detalles del personaje
        }
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // Layout de 2 columnas
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.charactersLiveData.observe(this, Observer { characters ->
            adapter.submitList(characters)
        })
    }

    private fun openCharacterDetail(character: DBCharacter) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra("character_id", character.id)
        intent.putExtra("character_name", character.name)
        intent.putExtra("character_image", character.image)
        intent.putExtra("character_ki", character.ki)
        intent.putExtra("character_max_ki", character.maxKi)
        intent.putExtra("character_race", character.race)
        intent.putExtra("character_gender", character.gender)
        intent.putExtra("character_description", character.description)
        startActivity(intent)
    }
}
