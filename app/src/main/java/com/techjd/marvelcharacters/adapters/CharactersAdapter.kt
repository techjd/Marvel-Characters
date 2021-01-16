package com.techjd.marvelcharacters.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techjd.marvelcharacters.R
import com.techjd.marvelcharacters.models.characters.Result

import com.techjd.marvelcharacters.viewholders.CharactersViewHolder

class CharactersAdapter(val data: List<Result>, val context: Context) :
    RecyclerView.Adapter<CharactersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout_characters,
            parent, false
        )
        return CharactersViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val characters = data[position]
        holder.name.text = characters.name
//        holder.desc.text = characters.description
        val image = "${characters.thumbnail.path}/standard_amazing.jpg"
        Glide.with(context).load(image).into(holder.image)
        holder.card.setOnClickListener {
            Toast.makeText(context, characters.name, Toast.LENGTH_SHORT).show()
        }


    }
}