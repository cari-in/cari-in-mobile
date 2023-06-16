package com.example.cariinapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.cariin.adapter.ImageAdapter
import com.example.cariinapp.R
import com.example.cariinapp.R.*
import com.example.cariinapp.component.Wishlist
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var findplace: Button
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var adapter: ImageAdapter
    private lateinit var imageList: ArrayList<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val findPlaceButton: Button = findViewById(id.FindButton)
        findPlaceButton.setOnClickListener {
            val intent = Intent(this, Baliplaces::class.java)
            startActivity(intent)
        }

        init()
        setUpBali()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu resource file
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle menu item clicks
        when (item.itemId) {
            id.wishtlist -> {
                val intent = Intent(this, Wishlist::class.java)
                startActivity(intent)
                return true
            }

            id.Profile -> {
                // Handle Profile item click
                // Add your desired action here
                return true
            }

            id.Logout -> {
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

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpBali() {
        val bali = CompositePageTransformer()
        bali.addTransformer(MarginPageTransformer(40))
        bali.addTransformer { page, position ->
            val r = 1 - abs(position)
            val scale = 1f - r * 0.15f // Adjust the scale factor as needed
            page.scaleY = scale
            page.scaleX = scale
            page.translationY = r * 60 // Adjust the vertical translation as needed
        }

        viewPager2.setPageTransformer(bali)
    }
    private fun init() {
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.bali1)
        imageList.add(R.drawable.bali2)
        imageList.add(R.drawable.bali3)
        imageList.add(R.drawable.bali3)
        imageList.add(R.drawable.bali4)

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = ViewPager2.OVER_SCROLL_NEVER
    }
}




