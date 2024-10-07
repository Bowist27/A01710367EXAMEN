package com.example.a01710367examen.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
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
        adapter = CharactersAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // Layout de 2 columnas
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.charactersLiveData.observe(this, Observer { characters ->
            adapter.submitList(characters)
        })
    }
}
