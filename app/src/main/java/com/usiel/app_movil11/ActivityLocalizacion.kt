package com.usiel.app_movil11

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class ActivityLocalizacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizacion)

        // Intentar encontrar el botón
        val buttonBack: Button? = findViewById(R.id.buttonBack)
        if (buttonBack == null) {
            Log.e("ActivityLocalizacion", "El botón no se encontró en el layout.")
        } else {
            // Configurar el evento onClick para regresar a la pantalla anterior
            buttonBack.setOnClickListener {
                finish()  // Cierra la actividad actual y regresa a la anterior
            }
        }
    }
}
