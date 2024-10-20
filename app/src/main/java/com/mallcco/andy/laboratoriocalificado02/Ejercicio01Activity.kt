package com.mallcco.andy.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mallcco.andy.laboratoriocalificado02.databinding.ActivityEjercicio01Binding

class Ejercicio01Activity : AppCompatActivity() {


    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityEjercicio01Binding.inflate(layoutInflater)


        setContentView(binding.root)


        enableEdgeToEdge()


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnMostrar.setOnClickListener {
            binding.viewGreen.visibility = View.VISIBLE
        }


        binding.btnOcultar.setOnClickListener {
            binding.viewGreen.visibility = View.GONE
        }
    }
}
