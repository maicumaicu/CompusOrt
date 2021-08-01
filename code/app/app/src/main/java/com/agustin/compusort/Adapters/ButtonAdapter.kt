package com.agustin.compusort.Adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.agustin.compusort.AulaBase
import com.agustin.compusort.MainActivity
import com.agustin.compusort.R

class ButtonAdapter(data:ArrayList<String>,context: Context,) : RecyclerView.Adapter<ButtonAdapter.ViewHolder>() {
    var datos = data
    var contexto = context
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemButton: TextView
        init {
            itemButton = itemView.findViewById(R.id.Button)

        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.button_base, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemButton.text = datos[i]
        viewHolder.itemButton.setOnClickListener {
            var intent = Intent(contexto, AulaBase::class.java)
            intent.putExtra("curso", datos[i]);
            contexto.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return datos.size
    }
}