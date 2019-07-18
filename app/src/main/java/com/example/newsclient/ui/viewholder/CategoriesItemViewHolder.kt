package com.example.newsclient.ui.viewholder

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R

class CategoriesItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name : TextView = itemView.findViewById(R.id.categoryNameTXT)

    fun summonCategoryJob(categoryName : String?){
        Log.d("CategoriesItem",categoryName)
        name.text = categoryName
    }

}