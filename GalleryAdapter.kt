package com.example.labtask

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(
    private val context: Context,
    private val galleryItems: List<GalleryItem>
) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val galleryItem = galleryItems[position]
        holder.title.text = galleryItem.title
        holder.image.setImageResource(galleryItem.imageResId)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, GalleryDetailActivity::class.java).apply {
                putExtra("title", galleryItem.title)
                putExtra("description", galleryItem.description)
                putExtra("imageResId", galleryItem.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = galleryItems.size

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.galleryTitle)
        val image: ImageView = itemView.findViewById(R.id.galleryImage)
    }
}
