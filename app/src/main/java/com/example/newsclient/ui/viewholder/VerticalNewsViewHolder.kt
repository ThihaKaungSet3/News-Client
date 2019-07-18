package com.example.newsclient.ui.viewholder

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.ui.adapter.NewsAdapter

class VerticalNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val topNewsRecyclerView : RecyclerView = itemView.findViewById(R.id.foryouRecycler)

    fun initiateVerticalViewHolder(context: Context?,articleList: List<Articles>){
        val newsAdapter  = NewsAdapter(context,0)
        newsAdapter.setArticleLists(articleList)
        topNewsRecyclerView.layoutManager = LinearLayoutManager(context)!!
        topNewsRecyclerView.addItemDecoration(VerticalItemDecoration(ContextCompat.getDrawable(context!!,R.drawable.divider)))
        topNewsRecyclerView.adapter = newsAdapter
    }

}