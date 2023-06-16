package com.example.cariinapp.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cariinapp.R
import com.example.cariinapp.result.button.Gunung
import com.example.cariinapp.result.button.Pantai
import com.example.cariinapp.result.button.Perkebunan
import com.example.cariinapp.result.button.Perkotaan
import com.example.cariinapp.result.button.Sungai

class Panorama : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panorama)

        val perkotaanButton: Button = findViewById(R.id.Perkotaan)
        val pantaiButton: Button = findViewById(R.id.Pantai)
        val airTerjunButton: Button = findViewById(R.id.airterjun)
        val perkebunanButton: Button = findViewById(R.id.Perkebunan)
        val gunungButton: Button = findViewById(R.id.Gunung)

        perkotaanButton.setOnClickListener {
            val intent = Intent(this, Perkotaan::class.java)
            startActivity(intent)
        }

        pantaiButton.setOnClickListener {
            val intent = Intent(this, Pantai::class.java)
            startActivity(intent)
        }

        airTerjunButton.setOnClickListener {
            val intent = Intent(this, Sungai::class.java)
            startActivity(intent)
        }

        perkebunanButton.setOnClickListener {
            val intent = Intent(this, Perkebunan::class.java)
            startActivity(intent)
        }

        gunungButton.setOnClickListener {
            val intent = Intent(this, Gunung::class.java)
            startActivity(intent)
        }

    }
}