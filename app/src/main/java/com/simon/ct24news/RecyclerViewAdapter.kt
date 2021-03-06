package com.simon.ct24news

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter (private val data: List<ArticleInfo>, private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.findViewById<TextView>(R.id.heading).text = item.title
        Log.d("Recycler view",item.type)
        if(item.type == "article") {
            Log.d("Recycler view","loading img")
            Glide.with(holder.itemView.context)
                .load(item.images[0].srcPhoneThumbnail)
                .into(holder.itemView.findViewById(R.id.img))
            holder.itemView.setOnClickListener{
                viewModel.currentId = item.getId()
                holder.itemView.findNavController().navigate(R.id.action_mainFragment_to_articleFragment)
            }
        }else{
            holder.itemView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}