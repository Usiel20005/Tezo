package com.usiel.app_movil11.datanegocios

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usiel.app_movil11.R

class AnuncioAdapter(private var anuncios: List<ItemAnuncio>) : RecyclerView.Adapter<AnuncioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnuncioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anuncio, parent, false)
        return AnuncioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnuncioViewHolder, position: Int) {
        val anuncio = anuncios[position]
        holder.titulo.text = anuncio.titulo
        holder.descripcion.text = anuncio.descripcion
        holder.direccion.text = anuncio.direccion
        holder.fecha.text = anuncio.horario
        holder.condicion.text = anuncio.telefono
        holder.imagen.setImageResource(anuncio.ImagenResId)

        // Actualizar el estado del ícono de favorito
        holder.favButton.setImageResource(
            if (anuncio.isFavorito)
                R.drawable.icono_favorito_relleno
            else
                R.drawable.icono_favorito
        )

        // Configurar el clic en el botón de favorito
        holder.favButton.setOnClickListener {
            // Cambiar el estado de favorito
            anuncio.isFavorito = !anuncio.isFavorito
            // Actualizar el ícono del botón
            notifyItemChanged(position) // Notificar al adapter que se ha cambiado un item
        }
    }

    override fun getItemCount(): Int {
        return anuncios.size
    }
    //  Metodo para actualizando la lista
    fun updateList (newAnuncios: List<ItemAnuncio>) {
        anuncios = newAnuncios
        notifyDataSetChanged()


    }




}
