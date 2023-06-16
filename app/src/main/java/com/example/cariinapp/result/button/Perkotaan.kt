package com.example.cariinapp.result.button

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cariinapp.R
import com.example.cariinapp.result.button.badung.badungmonumen
import com.example.cariinapp.result.button.badung.badungmuseum
import com.example.cariinapp.result.button.badung.badungperkotaansov
import com.example.cariinapp.result.button.badung.badungrestaurant
import com.example.cariinapp.result.button.resultpanorama.PerkotaanResult

class Perkotaan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perkotaan)

        val monumenButton = findViewById<Button>(R.id.Perkotaanmonumen)
        val souvenirButton = findViewById<Button>(R.id.Perkotaansouvenir)
        val restaurantButton = findViewById<Button>(R.id.Perkotaanrestaurant)
        val museumButton = findViewById<Button>(R.id.Perkotaanmuseum)

        monumenButton.setOnClickListener {
            val intent = Intent(this, badungmonumen::class.java)
            startActivity(intent)
        }

        souvenirButton.setOnClickListener {
            val intent = Intent(this, badungrestaurant::class.java)
            startActivity(intent)
        }

        restaurantButton.setOnClickListener {
            val intent = Intent(this, badungrestaurant::class.java)
            startActivity(intent)
        }

        museumButton.setOnClickListener {
            val intent = Intent(this, badungmuseum::class.java)
            startActivity(intent)
        }
    }
}