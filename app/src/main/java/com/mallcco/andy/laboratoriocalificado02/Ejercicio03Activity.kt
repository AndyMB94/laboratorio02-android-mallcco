package com.mallcco.andy.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mallcco.andy.laboratoriocalificado02.databinding.ActivityEjercicio03Binding

class Ejercicio03Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio03Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibir los datos desde Ejercicio02Activity
        val nombreCliente = intent.getStringExtra("nombreCliente") ?: "No disponible"
        val numeroCliente = intent.getStringExtra("numeroCliente") ?: "No disponible"
        val productos = intent.getStringExtra("productos") ?: "No disponible"
        val direccion = intent.getStringExtra("direccion") ?: "No disponible"

        // Mostrar la información en la interfaz
        binding.tvNombreCliente.text = nombreCliente
        binding.tvNumeroCliente.text = numeroCliente

        // Configurar eventos de los botones
        binding.btnLlamar.setOnClickListener {
            llamarCliente(numeroCliente)
        }

        binding.btnWhatsApp.setOnClickListener {
            enviarMensajeWhatsApp(nombreCliente, productos, direccion)
        }
    }

    // Función para llamar a la aplicación de teléfono
    private fun llamarCliente(numero: String?) {
        if (!numero.isNullOrEmpty()) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numero")
            startActivity(intent)
        }
    }

    // Función para enviar un mensaje de WhatsApp con la información
    private fun enviarMensajeWhatsApp(nombreCliente: String?, productos: String?, direccion: String?) {
        if (!nombreCliente.isNullOrEmpty() && !productos.isNullOrEmpty() && !direccion.isNullOrEmpty()) {
            val mensaje = "Hola $nombreCliente, Tus productos: $productos están en camino a la dirección: $direccion"
            val uri = Uri.parse("https://wa.me/?text=${Uri.encode(mensaje)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.whatsapp")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
