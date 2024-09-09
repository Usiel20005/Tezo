package com.usiel.app_movil11.datanegocios

//Las variables son
data class ItemAnuncio(
    //Objetos de nuestra clase --> negocio
    val titulo: String,
    val descripcion: String,
    val direccion: String,
    val horario: String,
    val telefono: String,
    val ImagenResId: Int,
    var isFavorito: Boolean
)