package com.example.newsclient.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.squareup.picasso.Picasso

class VerticalNewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var categoryTextView : TextView = itemView.findViewById(R.id.categoryTXT)
    private var newsTitleTextView : TextView = itemView.findViewById(R.id.news_titleTXT)
    private var mediaNameTextView : TextView = itemView.findViewById(R.id.mediaNameTXT)
    private var timeTextView : TextView = itemView.findViewById(R.id.timeTXT)
    private var newsImageView : ImageView = itemView.findViewById(R.id.news_image)
    private var bookmarkImageView : ImageView = itemView.findViewById(R.id.bookmarkImage)
    private var shareImageView : ImageView = itemView.findViewById(R.id.shareImage)



    fun havefunwithViews(articles: Articles){
        newsTitleTextView.text = articles.title
        mediaNameTextView.text = articles.source.name
        Picasso.get().load(articles.urlToImage).centerCrop().fit().into(newsImageView)
        categoryTextView.text = "Category"
    }


}