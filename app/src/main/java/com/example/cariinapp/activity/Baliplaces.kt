package com.example.cariinapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.cariinapp.R
import com.example.cariinapp.component.Wishlist
import com.example.cariinapp.result.Panorama
import com.google.firebase.auth.FirebaseAuth

class Baliplaces : AppCompatActivity() {
    private lateinit var btnBadung: Button
    private lateinit var btnBangli: Button
    private lateinit var btnBuleleng: Button
    private lateinit var btnDenpasar: Button
    private lateinit var btnGianyar: Button
    private lateinit var btnJembrana: Button
    private lateinit var btnKarangasem: Button
    private lateinit var btnKlungkung: Button
    private lateinit var btnTabanan: Button
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baliplaces)


        btnBadung = findViewById(R.id.Badung)
        btnBangli = findViewById(R.id.Bangli)
        btnBuleleng = findViewById(R.id.Buleleng)
        btnDenpasar = findViewById(R.id.Denpasar)
        btnGianyar = findViewById(R.id.Gianyar)
        btnJembrana = findViewById(R.id.Jembrana)
        btnKarangasem = findViewById(R.id.Karangasem)
        btnKlungkung = findViewById(R.id.Klungkung)
        btnTabanan = findViewById(R.id.Tabanan)

        btnBadung.setOnClickListener { handleClick(btnBadung) }
        btnBangli.setOnClickListener { handleClick(btnBangli) }
        btnBuleleng.setOnClickListener { handleClick(btnBuleleng) }
        btnDenpasar.setOnClickListener { handleClick(btnDenpasar) }
        btnGianyar.setOnClickListener { handleClick(btnGianyar) }
        btnJembrana.setOnClickListener { handleClick(btnJembrana) }
        btnKarangasem.setOnClickListener { handleClick(btnKarangasem) }
        btnKlungkung.setOnClickListener { handleClick(btnKlungkung) }
        btnTabanan.setOnClickListener { handleClick(btnTabanan) }
    }


    private fun handleClick(button: Button) {
        when (button.id) {
            R.id.Badung -> {
                navigateToMainActivity("Badung")
            }

            R.id.Bangli -> {
                navigateToMainActivity("Bangli")
            }

            R.id.Buleleng -> {
                navigateToMainActivity("Buleleng")
            }

            R.id.Denpasar -> {
                navigateToMainActivity("Denpasar")
            }

            R.id.Gianyar -> {
                navigateToMainActivity("Gianyar")
            }

            R.id.Jembrana -> {
                navigateToMainActivity("Jembrana")
            }

            R.id.Karangasem -> {
                navigateToMainActivity("Karangasem")
            }

            R.id.Klungkung -> {
                navigateToMainActivity("Klungkung")
            }

            R.id.Tabanan -> {
                navigateToMainActivity("Tabanan")
            }
        }

    }

    private fun navigateToMainActivity(location: String) {
        val intent = Intent(this, Panorama::class.java)
        intent.putExtra("location", location)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu resource file
        menuInflater.inflate(R.menu.main_menu, menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle menu item clicks
        when (item.itemId) {
            R.id.wishtlist -> {
                val intent = Intent(this, Wishlist::class.java)
                startActivity(intent)
                return true
            }

            R.id.Profile -> {
                // Handle Profile item click
                // Add your desired action here
                return true
            }

            R.id.Logout -> {
                // Handle Logout item click
                FirebaseAuth.getInstance().signOut()
                // Add your desired action here, such as navigating to the login screen
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish() // Prevents user from navigating back to MainActivity
                return true
            }
        }

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}