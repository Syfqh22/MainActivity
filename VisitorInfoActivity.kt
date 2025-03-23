package com.example.labtask

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class VisitorInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitor_info)

        // Open Google Maps when button is clicked
        val btnOpenMap = findViewById<Button>(R.id.btnOpenMap)
        btnOpenMap.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:3.1412,101.6865?q=Museum of Islamic Art Malaysia")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        // Bottom Navigation Setup
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.nav_exhibitions -> {
                    startActivity(Intent(this, ExhibitionsActivity::class.java))
                    true
                }
                R.id.nav_visitor_info -> true // Stay on this page
                R.id.nav_gallery -> {
                    startActivity(Intent(this, GalleryActivity::class.java))
                    true
                }
                else -> false
            }
        }

        bottomNavigation.selectedItemId = R.id.nav_visitor_info
    }
}
