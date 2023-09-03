package com.curso.android.app.practica.proyticmas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.proyticmas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private val mainViewModel: MainViewModel by viewModels()

       override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

           mainViewModel.palabra.observe(this){
               println("Se generan cambios en viewModel. $it")
               println("Evalua binding text")
               println("Evalua estado")
               binding.textResultado.text = it.estado
           }

           binding.btnComparar.setOnClickListener {
               val pepe = binding.palabra1.text.trim().toString()
               val pepe2 = binding.palabra2.text.trim().toString()
               binding.textResultado.text = binding.palabra1.text.toString()
               mainViewModel.compararPalabras(pepe,pepe2,"")
           }
    }
}