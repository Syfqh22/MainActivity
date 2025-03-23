package com.example.labtask

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewGallery)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        val galleryItems = listOf(
            GalleryItem("Ottoman Room (Damascus Room)", "An 18th-century reception hall from Damascus, Syria, with intricate woodwork, gold leaf, and Arabic calligraphy.", R.drawable.art1),
            GalleryItem("The Ardabil Carpet", "A masterpiece of Persian carpet weaving, featuring intricate floral designs and calligraphy.", R.drawable.art2),
            GalleryItem("The Blue Quran", "A rare manuscript with gold Kufic script on deep blue parchment, showcasing early Islamic calligraphy.", R.drawable.art3),
            GalleryItem("Malay Keris Dagger", "A traditional Malay dagger with a wavy blade, known for its spiritual significance and intricate craftsmanship.", R.drawable.art4),
            GalleryItem("Mughal Jade Dagger", "A finely crafted Mughal-era dagger made from jade, inlaid with precious stones, symbolizing royal power.", R.drawable.art5),
            GalleryItem("Iznik Tile Panel", "A vibrant ceramic panel from Ottoman Turkey, featuring intricate floral and geometric designs.", R.drawable.art6),
            GalleryItem("Astrolabe", "An ancient Islamic astronomical instrument used for navigation, prayer times, and celestial calculations.", R.drawable.art7),
            GalleryItem("Safavid Miniature Painting", "A delicate Persian miniature painting from the Safavid era, depicting historical and literary scenes.", R.drawable.art8),
            GalleryItem("Mamluk Brass Basin", "An intricately engraved brass basin from the Mamluk period, showcasing Arabic calligraphy and decorative motifs.", R.drawable.art9),
            GalleryItem("Fatimid Rock Crystal Ewer", "A rare rock crystal ewer from the Fatimid dynasty, carved with precision and once used in royal courts.", R.drawable.art10)
        )

        recyclerView.adapter = GalleryAdapter(this, galleryItems)

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
                R.id.nav_visitor_info -> {
                    startActivity(Intent(this, VisitorInfoActivity::class.java))
                    true
                }
                R.id.nav_gallery -> true // Stay on this page
                else -> false
            }
        }

        bottomNavigation.selectedItemId = R.id.nav_gallery
    }
}
