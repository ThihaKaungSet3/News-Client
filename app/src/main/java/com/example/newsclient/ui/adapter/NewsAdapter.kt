package com.example.newsclient.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.ui.viewholder.HorizontalNewsItemViewHolder
import com.example.newsclient.ui.viewholder.VerticalNewsItemViewHolder

class NewsAdapter(context: Context?,orientation : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val VERTICAL = 0
        private const val HORIZONTAL = 1
    }

    private var context: Context? = context
    private var orientation : Int = orientation
    private lateinit var articles : List<Articles>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(orientation){
            VERTICAL -> VerticalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_news_item,parent,false))
            HORIZONTAL -> HorizontalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_item,parent,false))

            else -> VerticalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_news_item,parent,false))
        }
    }


    fun setArticleLists(articles: List<Articles>){
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var article : Articles = articles[position]

        when(orientation){
            VERTICAL -> {
                val verticalNewsItem :  VerticalNewsItemViewHolder = holder as VerticalNewsItemViewHolder
                verticalNewsItem.havefunwithViews(article)
            }
            HORIZONTAL -> {
                val horizontalNewsItem : HorizontalNewsItemViewHolder = holder as HorizontalNewsItemViewHolder
                horizontalNewsItem.dancingwithViews(article)
            }
        }
    }



}