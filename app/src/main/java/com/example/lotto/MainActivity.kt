package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constellcardView = findViewById<CardView>(R.id.constellationcard)
        val namecardView = findViewById<CardView>(R.id.namecard)

        constellcardView.setOnClickListener{
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }
        namecardView.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }
    }
}