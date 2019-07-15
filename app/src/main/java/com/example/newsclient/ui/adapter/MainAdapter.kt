package com.example.newsclient.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.data.MainNews
import com.example.newsclient.data.News
import com.example.newsclient.ui.viewholder.HorizontalNewsViewHolder
import com.example.newsclient.ui.viewholder.VerticalNewsItemViewHolder
import com.example.newsclient.ui.viewholder.VerticalNewsViewHolder

class MainAdapter (context : Context?, newsList: List<MainNews>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val TOP_NEWS : Int = 0
        const val TECH_NEWS : Int = 1
        const val SHUFFLE_NEWS : Int = 2
        const val SPORT_NEWS : Int = 3

    }

    private var context : Context? = context
    private var newsList: List<MainNews> = newsList

    /**
     * will be change to some value
     */
    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> TOP_NEWS
            1 -> TECH_NEWS
            2 -> SHUFFLE_NEWS
            3 -> SPORT_NEWS

            else -> 4
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TOP_NEWS -> {
                VerticalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.top_news_list_area,parent,false))
            }
            TECH_NEWS -> {
                HorizontalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_list_area,parent,false))
            }
            SPORT_NEWS -> {
                HorizontalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_list_area,parent,false))
            }

            else -> VerticalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_news_item,parent,false))
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)){
            TOP_NEWS -> {

                val verticalViewHolder : VerticalNewsViewHolder = holder as VerticalNewsViewHolder
                verticalViewHolder.initiateVerticalViewHolder(context,getArticlesByPosition(position))
            }
            TECH_NEWS -> {
                val horizontalViewHolder : HorizontalNewsViewHolder = holder as HorizontalNewsViewHolder
                horizontalViewHolder.haveFunWithView(context,getArticlesByPosition(position),"Technology News")
            }
            SPORT_NEWS -> {
                val horizontalViewHolder : HorizontalNewsViewHolder = holder as HorizontalNewsViewHolder
                horizontalViewHolder.haveFunWithView(context,getArticlesByPosition(position),"Sport News")
            }

            else ->  {
                val  verticalNewsItemViewHolder : VerticalNewsItemViewHolder = holder as VerticalNewsItemViewHolder
            }

        }

    }

    fun getArticlesByPosition(position : Int) : List<Articles>{
        val  mainNews : MainNews = newsList[position]

        return mainNews.articles
    }





}