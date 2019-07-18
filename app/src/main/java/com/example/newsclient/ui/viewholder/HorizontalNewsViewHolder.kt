package com.example.newsclient.ui.viewholder

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.ui.adapter.NewsAdapter

class HorizontalNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private  var categoryTXT : TextView = itemView.findViewById(R.id.categoryTXT) as TextView
    private var horizontalRecyclerView : RecyclerView = itemView.findViewById(R.id.horizontalNewsRecyclerView) as RecyclerView

    fun haveFunWithView(context: Context?, articleList: List<Articles>,category : String){
        categoryTXT.text = category
        val newsAdapter = NewsAdapter(context,1)
        newsAdapter.setArticleLists(articleList)

        horizontalRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = newsAdapter
        }

    }

}