package com.example.newsclient.ui.viewholder

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.ui.adapter.NewsAdapter

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val categoryRecycler : RecyclerView = itemView.findViewById(R.id.categoriesRecyclerView)

    fun setUpCategories(context:Context ,categories : Array<String>){
        Log.d("Categories","$categories")
        val newsAdapter = NewsAdapter(context,69,categories)

        categoryRecycler.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = newsAdapter
        }
    }
}