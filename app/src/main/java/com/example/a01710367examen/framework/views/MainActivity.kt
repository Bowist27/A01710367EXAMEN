package com.example.a01710367examen.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.a01710367examen.R
import com.example.a01710367examen.data.network.APIClient
import com.example.a01710367examen.data.network.Repository
import com.example.a01710367examen.databinding.ActivityMainBinding
import com.example.a01710367examen.framework.viewmodel.MainViewModel

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
//        initializeObservers()

        // viewModel.get...
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}
