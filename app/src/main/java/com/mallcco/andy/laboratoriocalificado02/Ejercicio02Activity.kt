package com.mallcco.andy.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mallcco.andy.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Evento al presionar el botón Registrar
        binding.btnRegistrar.setOnClickListener {
            if (validarInputs()) {
                // Enviar los datos a la siguiente actividad
                val intent = Intent(this, Ejercicio03Activity::class.java)
                intent.putExtra("nombreCliente", binding.etNombreCliente.text.toString())
                intent.putExtra("numeroCliente", binding.etNumeroCliente.text.toString())
                intent.putExtra("productos", binding.etProductos.text.toString())
                intent.putExtra("ciudad", binding.etCiudad.text.toString())
                intent.putExtra("direccion", binding.etDireccion.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Validar si todos los campos están completos
    private fun validarInputs(): Boolean {
        return !(binding.etNombreCliente.text.isNullOrEmpty() ||
                binding.etNumeroCliente.text.isNullOrEmpty() ||
                binding.etProductos.text.isNullOrEmpty() ||
                binding.etCiudad.text.isNullOrEmpty() ||
                binding.etDireccion.text.isNullOrEmpty())
    }
}
