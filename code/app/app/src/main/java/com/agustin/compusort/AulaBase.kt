package com.agustin.compusort


import android.R.attr.data
import android.R.attr.fillBefore
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agustin.compusort.Adapters.CompusAdapter
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class AulaBase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var datos = intent.extras?.getString("curso")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aula_base)
        FirebaseApp.initializeApp(this)
        val db = Firebase.database
        val myRef = datos?.let { db.getReference(it) }
        var textView = findViewById<TextView>(R.id.cursoText)
        textView.text = datos
        if (myRef != null) {
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    val value = dataSnapshot.getValue<ArrayList<Boolean>>()
                    val recyclerView = findViewById<RecyclerView>(R.id.compusState)
                    val numberOfColumns = 5
                    recyclerView.layoutManager = GridLayoutManager(this@AulaBase,numberOfColumns)
                    recyclerView.adapter = value?.let { CompusAdapter(it) }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                }
            })
        }
    }
}