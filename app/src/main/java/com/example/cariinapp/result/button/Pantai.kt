package com.example.cariinapp.result.button

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cariinapp.R
import com.example.cariinapp.result.button.resultpanorama.PantaiResult
import com.example.cariinapp.result.denpasar.resultdenpasar
import com.example.cariinapp.result.denpasar.resultdenpasarswim

class Pantai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantai)

        val pantaiberenangButton: Button = findViewById(R.id.Pantaiberenang)
        pantaiberenangButton.setOnClickListener {
            handleClick(pantaiberenangButton)
        }

        val pantaispotfotopantaiButton: Button = findViewById(R.id.pantaiberjemur)
        pantaispotfotopantaiButton.setOnClickListener {
            handleClick(pantaispotfotopantaiButton)
        }
    }

    private fun handleClick(button: Button) {
        when (button.id) {
            R.id.Pantaiberenang -> {
                val intent = Intent(this, resultdenpasarswim::class.java)
                startActivity(intent)
            }
            R.id.pantaiberjemur -> {
                val intent = Intent(this, resultdenpasar::class.java)
                startActivity(intent)
            }
            // Handle other button clicks if needed
        }
    }
}