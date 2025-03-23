package com.example.labtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find buttons
        val btnExhibitions = findViewById<ImageButton>(R.id.btnExhibitions)
        val btnVisitorInfo = findViewById<ImageButton>(R.id.btnVisitorInfo)
        val btnGallery = findViewById<ImageButton>(R.id.btnGallery)

        // Set click listeners
        btnExhibitions.setOnClickListener {
            startActivity(Intent(this, ExhibitionsActivity::class.java))
        }

        btnVisitorInfo.setOnClickListener {
            startActivity(Intent(this, VisitorInfoActivity::class.java))
        }

        btnGallery.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
        }
    }
}
