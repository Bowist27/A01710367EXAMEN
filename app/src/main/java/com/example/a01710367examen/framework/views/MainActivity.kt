package com.example.a01710367examen.framework.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a01710367examen.R
import com.example.a01710367examen.data.models.DBCharacter
import com.example.a01710367examen.databinding.ActivityMainBinding
import com.example.a01710367examen.framework.adapter.CharactersAdapter
import com.example.a01710367examen.framework.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CharactersAdapter

    private var currentPage = 1 // Página actual
    private var isLoading = false // Estado de carga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setupRecyclerView()
        setupObservers()

        loadCharacters() // Cargar los personajes inicialmente
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        adapter = CharactersAdapter { character -> openCharacterDetail(character) }
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // Layout de 2 columnas
        binding.recyclerView.adapter = adapter

        // Listener para detectar el desplazamiento
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    loadMoreCharacters() // Cargar más personajes cuando se llegue al final
                }
            }
        })
    }

    private fun setupObservers() {
        viewModel.charactersLiveData.observe(this, Observer { characters ->
            adapter.submitList(characters) // Actualizar el adapter con los nuevos personajes
            hideLoadingIndicator() // Ocultar el GIF de carga
            isLoading = false // Cambiar el estado de carga
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

    private fun loadCharacters() {
        isLoading = true // Indicar que se está cargando
        showLoadingIndicator() // Mostrar GIF de carga
        viewModel.getCharacters(currentPage * 10) // Obtener personajes para la página actual
    }

    private fun loadMoreCharacters() {
        currentPage++ // Incrementar la página
        loadCharacters() // Cargar más personajes
    }

    private fun showLoadingIndicator() {
        binding.loadingIndicator.visibility = View.VISIBLE
        Glide.with(this)
            .load(R.drawable.anim) // Asegúrate de que este GIF exista
            .into(binding.loadingImage)
    }

    private fun hideLoadingIndicator() {
        binding.loadingIndicator.visibility = View.GONE
    }
}
