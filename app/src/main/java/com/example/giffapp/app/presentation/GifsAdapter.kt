package com.example.giffapp.app.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giffapp.R
import com.example.giffapp.data.model.GiphyData

class GifsAdapter(val context: Context, val gifs: MutableList<GiphyData>) : RecyclerView.Adapter<GifsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return gifs.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = gifs[position]

        Glide.with(context).load(data.images.ogImage.url)
            .into(holder.imageView)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.ivGif)

    }
}
