package com.example.cariinapp.result.button

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cariinapp.R
import com.example.cariinapp.result.button.bangli.banglispot
import com.example.cariinapp.result.button.bangli.banglitreckking

class Gunung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gunung)

        val gunungspotfotoButton: Button = findViewById(R.id.Gunungspotfoto)
        gunungspotfotoButton.setOnClickListener {
            handleClick(gunungspotfotoButton)
        }

        val gunungtreckkingButton: Button = findViewById(R.id.Gunungtreckking)
        gunungtreckkingButton.setOnClickListener {
            handleClick(gunungtreckkingButton)
        }
    }
    private fun handleClick(button: Button) {
        when (button.id) {
            R.id.Gunungspotfoto -> {
                val intent = Intent(this, banglispot::class.java)
                startActivity(intent)
            }
            R.id.Gunungtreckking -> {
                val intent = Intent(this, banglitreckking::class.java)
                startActivity(intent)
            }
        }
    }
}