package com.agustin.compusort.Adapters

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Intent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.agustin.compusort.R


class CompusAdapter(data:ArrayList<Boolean>): RecyclerView.Adapter<CompusAdapter.ViewHolder>() {
    var datos = data
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemNdeCompu: TextView
        var itemCross:ImageView
        init {
            itemNdeCompu = itemView.findViewById(R.id.NdeCompu)
            itemCross = itemView.findViewById(R.id.cross)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.compus_base, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemNdeCompu.text = i.toString()
        if(datos[i] == true){
            viewHolder.itemCross.visibility = View.INVISIBLE
        }else{
            viewHolder.itemCross.visibility = View.VISIBLE
        }

    }
    override fun getItemCount(): Int {
        return datos.size
    }
}