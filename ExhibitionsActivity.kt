package com.example.labtask

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExhibitionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exhibitions)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewExhibitions)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val exhibitions = listOf(
            Exhibition(
                "Oceans That Speak",
                "Islam’s influence on the Malay world through maritime trade.",
                "This exhibition explores how maritime trade facilitated cultural exchanges that shaped the Malay world. It highlights the spread of Islam through seafarers, merchants, and scholars, emphasizing their impact on language, art, and traditions. (Dec 13, 2024 – Jun 15, 2025)",
                R.drawable.exhibit1
            ),
            Exhibition(
                "The Arabesque",
                "Intricate patterns in Islamic art and their meanings.",
                "A deep dive into the intricate geometric, floral, and calligraphic patterns that define Islamic art. The exhibition showcases how these designs reflect spiritual harmony, mathematics, and artistic expression across different Islamic cultures. (Aug 15, 2024 – Oct 27, 2024)",
                R.drawable.exhibit2
            ),
            Exhibition(
                "Makkah, Madinah, Al-Quds & Istanbul",
                "Cultural and historical significance of four sacred cities.",
                "This exhibition examines the historical, religious, and cultural significance of these four sacred cities. Through artifacts, manuscripts, and artistic depictions, it reveals their enduring influence on the Islamic world. (Jul 30, 2024 – Oct 20, 2024)",
                R.drawable.exhibit3
            ),
            Exhibition(
                "A Journey Through Islamic Art",
                "Celebrating IAMM’s 25th anniversary through Islamic masterpieces.",
                "Marking the 25th anniversary of the Islamic Arts Museum Malaysia, this exhibition presents a diverse collection of Islamic artifacts. Spanning various regions and time periods, it includes manuscripts, ceramics, textiles, and metalwork that highlight the artistic and cultural achievements of the Islamic world. (Dec 13, 2023 – Jun 30, 2024)",
                R.drawable.exhibit4
            ),
            Exhibition(
                "Orientalist Paintings: Mirror or Mirage?",
                "Examining Western depictions of the Islamic world.",
                "This exhibition critically analyzes Orientalist paintings by Western artists and their portrayal of Eastern societies. It questions the authenticity and biases in these artworks while exploring how they shaped global perceptions of the Islamic world. (Jun 2, 2023 – Oct 15, 2023)",
                R.drawable.exhibit5
            ),
            Exhibition(
                "The Alhambra",
                "Architectural marvel and legacy of Islamic Spain.",
                "A tribute to the Alhambra, a UNESCO World Heritage site in Granada, Spain, renowned for its intricate Islamic architecture. This exhibition showcases historical artifacts, architectural designs, and cultural influences that define one of the most iconic monuments of Islamic civilization. (Jul 5, 2023 – Aug 6, 2023)",
                R.drawable.exhibit6
            )
        )

        recyclerView.adapter = ExhibitionAdapter(this, exhibitions)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.nav_exhibitions -> true
                R.id.nav_visitor_info -> {
                    startActivity(Intent(this, VisitorInfoActivity::class.java))
                    true
                }
                R.id.nav_gallery -> {
                    startActivity(Intent(this, GalleryActivity::class.java))
                    true
                }
                else -> false
            }
        }

        bottomNavigation.selectedItemId = R.id.nav_exhibitions
    }
}
