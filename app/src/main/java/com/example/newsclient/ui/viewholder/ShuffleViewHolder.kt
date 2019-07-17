package com.example.newsclient.ui.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.ui.adapter.NewsAdapter

class ShuffleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val shuffleRecyclerView  : RecyclerView = itemView.findViewById(R.id.shuffleRecyclerView)

    fun setArticles(context: Context?,articlesList : List<Articles>){
        val newsAdapter = NewsAdapter(context,0)
        newsAdapter.setArticleLists(articlesList)
        shuffleRecyclerView.layoutManager = LinearLayoutManager(context)
        shuffleRecyclerView.adapter = newsAdapter
    }
}