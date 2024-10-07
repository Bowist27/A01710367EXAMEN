package com.example.a01710367examen.framework.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.a01710367examen.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del Intent
        val characterName = intent.getStringExtra("character_name")
        val characterImage = intent.getStringExtra("character_image")
        val characterKi = intent.getStringExtra("character_ki")
        val characterMaxKi = intent.getStringExtra("character_max_ki")
        val characterRace = intent.getStringExtra("character_race")
        val characterGender = intent.getStringExtra("character_gender")
        val characterDescription = intent.getStringExtra("character_description")

        // Asignar los datos a la vista
        binding.characterName.text = characterName
        binding.characterKi.text = "Ki: $characterKi"
        binding.characterMaxKi.text = "Max Ki: $characterMaxKi"
        binding.characterRace.text = "Race: $characterRace"
        binding.characterGender.text = "Gender: $characterGender"
        binding.characterDescription.text = characterDescription

        Glide.with(this)
            .load(characterImage)
            .into(binding.characterImage)

        // Botón para regresar
        binding.backButton.setOnClickListener {
            finish() // Cierra la actividad y regresa
        }
    }
}
