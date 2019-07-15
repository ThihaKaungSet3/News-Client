package com.example.newsclient.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.squareup.picasso.Picasso

class HorizontalNewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var newsTitleTextView : TextView = itemView.findViewById(R.id.newstitleTXT)
    private var mediaNameTextView : TextView = itemView.findViewById(R.id.mediaNameTXT)
    private var dateTextView : TextView = itemView.findViewById(R.id.dateTXT)
    private var newsImageView : ImageView = itemView.findViewById(R.id.newsImg)


    fun dancingwithViews(articles: Articles){
        newsTitleTextView.text = articles.title
        mediaNameTextView.text = articles.source.name
        Picasso.get().load(articles.urlToImage).centerCrop().fit().into(newsImageView)
    }
}