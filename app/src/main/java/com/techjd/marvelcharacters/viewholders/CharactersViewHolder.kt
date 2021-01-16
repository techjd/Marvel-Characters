package com.techjd.marvelcharacters.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.techjd.marvelcharacters.R
import de.hdodenhof.circleimageview.CircleImageView

class CharactersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val image: CircleImageView = itemView.findViewById(R.id.character_Image)
    val name:TextView = itemView.findViewById(R.id.characterName)
    val card: CardView = itemView.findViewById(R.id.cardView)
//    val desc: TextView = itemView.findViewById(R.id.characterDescription)
}