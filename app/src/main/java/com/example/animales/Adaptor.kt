package com.example.animales

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptor(var context:Context, items:ArrayList<Animales>):BaseAdapter() {

    var items:ArrayList<Animales>? = null

    init {
        this.items = items
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Validar vista
        var holder:ViewHolder? = null

        var vista:View? = convertView
        if (vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as? ViewHolder
        }

        var item = getItem(position) as Animales
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)


        return vista!!
    }

    private class ViewHolder(vista:View){
        var nombre:TextView? =  null
        var imagen: ImageView? = null


        init {
            this.nombre = vista.findViewById(R.id.txtvImagen)
            this.imagen = vista.findViewById(R.id.ivAnimal)
        }
    }

}