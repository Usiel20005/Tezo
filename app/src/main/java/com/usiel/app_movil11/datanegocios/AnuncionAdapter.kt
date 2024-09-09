package com.usiel.app_movil11.datanegocios


import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usiel.app_movil11.R

class AnuncioViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    val titulo : TextView=itemView.findViewById(R.id.Tv_titulo)
    val descripcion : TextView =itemView.findViewById(R.id.Tv_descripcion)
    val direccion : TextView =itemView.findViewById(R.id.Tv_direccion)
    val fecha : TextView =itemView.findViewById(R.id.Tv_fecha)
    val condicion : TextView =itemView.findViewById(R.id.Tv_condicion)
    val imagen : ImageView =itemView.findViewById(R.id.imageIv)
    val favButton : ImageButton = itemView.findViewById(R.id.Ib_fav)
}