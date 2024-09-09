package com.usiel.app_movil11

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Creamos las variables KOTLIN -->xml
        var usuario: EditText = findViewById(R.id.edUsuario)
        var password: EditText = findViewById(R.id.edPaswword)
        var button: Button = findViewById(R.id.edInicio)
        var tvRegister: TextView = findViewById(R.id.tvRegister) // <-- Referencia al TextView "Regístrate"

        // Agregar un mensaje de depuración para verificar que onCreate se está ejecutando
        Log.d("MainActivity", "Método onCreate ejecutado")

        // Controlamos el evento (Click) del botón
        button.setOnClickListener {
            // Programamos si el usuario y la contraseña son correctos
            var username: String = "UAT"
            var userpassword: String = "123"
            // Recoger los valores de las cajas de texto
            var edUsuario: String = usuario.text.toString()
            var edPassword: String = password.text.toString()

            if (username.equals(edUsuario) && userpassword.equals(edPassword)) {
                // ABRIR LA SIGUIENTE PANTALLA
                Toast.makeText(this, "Usuario correcto", Toast.LENGTH_SHORT).show()

                // Abrir la siguiente pantalla
                var segundaPantalla = Intent(this, Principal::class.java)
                startActivity(segundaPantalla)

            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        // Controlar el evento (Click) del TextView "Regístrate"
        tvRegister.setOnClickListener {
            // Agregar un mensaje de depuración para verificar que el clic está siendo detectado
            Log.d("MainActivity", "TextView 'Regístrate' fue presionado")

            // Crear un Intent para abrir RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)

            // Iniciar la actividad
            startActivity(intent)
        }
    }
}
