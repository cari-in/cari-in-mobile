package com.example.cariinapp.result.button.resultpanorama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cariinapp.R

class Result : AppCompatActivity() {
    class Result : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_result)

            val selectedPlace = intent.getStringExtra("selectedPlace")
            // Use the selectedPlace value as needed
        }
    }
}