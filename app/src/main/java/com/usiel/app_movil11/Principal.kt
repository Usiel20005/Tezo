package com.usiel.app_movil11

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.usiel.app_movil11.datanegocios.AnuncioAdapter
import com.usiel.app_movil11.datanegocios.ItemAnuncio

class Principal : AppCompatActivity() {

    private lateinit var adapter: AnuncioAdapter
    private lateinit var anuncios: List<ItemAnuncio>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)



        val Buscar:EditText=findViewById(R.id.editTextText)



        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AnuncioAdapter(getAnuncios())
        recyclerView.adapter = adapter

        // Obtener el botón
        val button2: Button = findViewById(R.id.button2)

        // Configurar el evento onClick para abrir ActivityLocalizacion
        button2.setOnClickListener {
            val intent = Intent(this, ActivityLocalizacion::class.java)
            startActivity(intent)
        }




        anuncios = getAnuncios()

        /* Funcion para buscar */

        Buscar.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        } )
    }


    /*Metodo para filtrar anuncio segun el texto ingresado */

    private fun filter (text : String) {

        val anunciosfiltrados = anuncios.filter {
      anuncio ->
            anuncio.titulo.contains(text, ignoreCase = true) ||
                    anuncio.descripcion.contains(text, ignoreCase = true)
        }
        adapter.updateList(anunciosfiltrados)

    }









    private fun getAnuncios(): List<ItemAnuncio> {
        return listOf(
            ItemAnuncio("Garden", "Venta de Desayunos y comida", "Av. Juan Aldama #5, centro", "08:00 am. - 08:00 pm.", "77636881155 o 7731140252", R.drawable.garde, false),

            ItemAnuncio("Farmacia Digsa Medica", "Venta de medicamentos Genericos y de Patente ", "Juan Aldama 46, colonia centro", "08:00 am. - 09:00 pm.", "7637375179", R.drawable.digsa, false),

            ItemAnuncio("Restaurant Esperanza", "Venta de Marisco", "Tezontepec de Aldama, rio", "09:00 am. - 06:00 pm.", "Sin numero", R.drawable.esperanza, false),

          //   ItemAnuncio("Farmacia 6B", "Venta de medicamentos Genericos y de Patente", "Calle Allende", "09:00 am. - 09:00 pm.", "7716776380", R.drawable.feconomia, false),

         //   ItemAnuncio("Pothe restaurante ", "Venta de Marisco", "Calle Republica de chile s/n", "12:00 pm. - 07:00 pm.", "7721857594", R.drawable.farmacia, false),

           ItemAnuncio("Farmacia Guadalupana", "Venta de medicamentos Genericos y de Patente", "Av. insurgente #173,Panuaya", "08:00 am. - 11:00 pm.", "7731993673", R.drawable.guadalupana, false),

           ItemAnuncio("Restaurante el chino ", "Venta de Marisco", "Ctra. a Tezontepec de Aldama, Panuaya, 42763 Tezontepec de Aldama, Hgo.", "9:30 am. - 06:30 pm.", "7636880214", R.drawable.chino,false ),

           ItemAnuncio("Farmacia Hidalgo", "Venta de medicamentos Genericos y de Patente", "Av. insurgente #17,Panuaya", "08:00 am. - 11:00 pm.", "7637375090", R.drawable.hidalgo, false),

          ItemAnuncio("El asadero del oso ", "Venta de Marisco, cortes de carne y comida mexicana", "5 de Mayo 156, 42760 Tezontepec de Aldama, Hgo.", "10:00 am. - 07:00 pm.", "7731310890", R.drawable.oso, false),

           ItemAnuncio("Farmacia Economia", "Venta de medicamentos Genericos y de Patente", "Av. insurgentes", "08:00 am. - 09:00 pm.", "no tiene", R.drawable.eco, false),

            ItemAnuncio("chano's ", "Venta de comida mexicana", "Av. insurgentes, Centro Tezontepec de Aldama", "03:00 pm. - 07:00 pm.", "7731099539", R.drawable.chanos, false),

            ItemAnuncio("Farmacia Equicvalente", "Venta de medicamentos Genericos", "Av. insurgentes, panuaya", "08:00 am. - 08:00 pm.", "no tiene", R.drawable.equivalente, false),

         ItemAnuncio("El sopes ", "Venta de comida corrida y tradicional", " Centro Tezontepec de Aldama", "09:00 am. - 04:00 pm.", "7714129965", R.drawable.sopes, false),

            ItemAnuncio("Farmacia Lasaguil", "Venta de medicamentos Genericos y Patente", "Av. insurgentes #7, panuaya", "08:00 am. - 11:00 pm.", "no tiene", R.drawable.lasagil, false),

          ItemAnuncio("Barbacoa don Chemo ", "Venta de barbacoa", " Allende 28,centro,Tezontepec de Aldama", "09:00 am. - 04:00 pm.", "7714129965", R.drawable.chemio, false),

         ItemAnuncio("Farmacia del Centro", "Venta de medicamentos Genericos", "Calle. Abasolo, zona centro", "08:00 am. - 07:00 pm.", "no tiene", R.drawable.fpastillero, false),


           ItemAnuncio("Farmacia Villa", "Venta de medicamentos Genericos y Patente", "Av. Insurgentes Tezontepec de aldama ", "08:00 am. - 11:00 pm.", "7731304069", R.drawable.villa, false),

            ItemAnuncio("Farmacias Similares", "Venta de medicamentos Silmilares", "Av. Juan Aldama ", "08:00 am. - 10:00 pm.", "no tienen", R.drawable.similar, false),

           ItemAnuncio("Lonchereia The Brothers ", "Venta de tortas", "Av. Insurgentes #25, Panuaya", "09:00 am. - 11:00 pm.", "7711285343", R.drawable.brothers, false),

          // ItemAnuncio("Econofarmas", "Venta de medicamentos Patente y Generico", "Av. Juan Aldama ", "08:00 am. - 10:00 pm.", "7731161743", R.drawable.feconomia, false),

           ItemAnuncio("Restaurant don Julio", "Venta de tortas", "5 de mayo a un costado del rio", "11:00 am. - 11:00 pm.", "3326474823", R.drawable.julio, false),

          ItemAnuncio("Farmacia 911", "Venta de medicamentos Patente y Generico", "Centro ", "08:00 am. - 11:00 pm.", "7731306192", R.drawable.far911, false),

          // ItemAnuncio("Farmacias insurgentes", "Venta de medicamentos Patente, Generico y Similares", "Av. Insurgentes #25, Panuaya ", "08:00 am. - 10:30 pm.", "sin numero", R.drawable.far911, false),

          ItemAnuncio("Doña Ofe", "Venta de antojitos mexicanos", "Carretera Tezontepec-Tunititlán, Panuaya", "07:30 am. - 04:00 pm.", "sin numero", R.drawable.ofe, false),

          ItemAnuncio("Judas Tadeo", "Miscelánea", "Carretera Tezontepec-Tunititlán, Panuaya", "07:30 am. - 05:00 pm.", "sin numero", R.drawable.tienda1, false)



            )
    }
}
