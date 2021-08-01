package com.agustin.compusort

import android.content.Intent
import android.graphics.Canvas
import android.icu.lang.UCharacter
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agustin.compusort.Adapters.ButtonAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = arrayListOf<String>("NL3A","NL3B","NL4A","NL4B","NL5A","NL5B")
        var recyclerView = findViewById<RecyclerView>(R.id.cursosBtnArray)
        recyclerView.adapter = ButtonAdapter(button,this)
        recyclerView.layoutManager = GridLayoutManager(this,2)

    }
}