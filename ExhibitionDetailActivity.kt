package com.example.labtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ExhibitionDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exhibition_detail)

        val title = intent.getStringExtra("title")
        val fullDescription = intent.getStringExtra("fullDescription")
        val imageResId = intent.getIntExtra("imageResId", 0)

        findViewById<TextView>(R.id.detailTitle).text = title
        findViewById<TextView>(R.id.detailDescription).text = fullDescription
        findViewById<ImageView>(R.id.detailImage).setImageResource(imageResId)
    }
}
