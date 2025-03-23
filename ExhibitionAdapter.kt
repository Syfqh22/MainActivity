package com.example.labtask

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExhibitionAdapter(
    private val context: Context,
    private val exhibitions: List<Exhibition>
) : RecyclerView.Adapter<ExhibitionAdapter.ExhibitionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_exhibition, parent, false)
        return ExhibitionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExhibitionViewHolder, position: Int) {
        val exhibition = exhibitions[position]
        holder.title.text = exhibition.title
        holder.description.text = exhibition.shortDescription // Show only short description
        holder.image.setImageResource(exhibition.imageResId)

        // Open detail page when clicked
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ExhibitionDetailActivity::class.java).apply {
                putExtra("title", exhibition.title)
                putExtra("fullDescription", exhibition.fullDescription) // Send full description
                putExtra("imageResId", exhibition.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = exhibitions.size

    class ExhibitionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.exhibitionTitle)
        val description: TextView = itemView.findViewById(R.id.exhibitionDescription)
        val image: ImageView = itemView.findViewById(R.id.exhibitionImage)
    }
}
