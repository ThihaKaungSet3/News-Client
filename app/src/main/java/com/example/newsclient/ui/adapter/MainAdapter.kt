package com.example.newsclient.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.data.MainNews
import com.example.newsclient.ui.viewholder.*
import com.example.newsclient.util.Constants
import kotlin.math.log

class MainAdapter (context : Context?, newsList: List<MainNews>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val TOP_NEWS : Int = 0
        const val FOR_YOU : Int = 1
        const val SPORT_NEWS : Int = 2
        const val SHUFFLE_NEWS: Int = 3
        const val TECH_NEWS : Int = 4
    }

    private var context : Context? = context
    private var newsList: List<MainNews> = newsList

    /**
     * will be change to some value
     */
    override fun getItemViewType(position: Int): Int {
        val mainNews = newsList[position]
        return when(mainNews.type){
            Constants.TOP -> TOP_NEWS
            Constants.FORYOU -> FOR_YOU
            Constants.SHUFFLE -> SHUFFLE_NEWS
            Constants.SPORT -> SPORT_NEWS
            Constants.TECH -> TECH_NEWS

            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TOP_NEWS -> {
                HorizontalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_list_area,parent,false))
            }
            FOR_YOU -> {
                VerticalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.foryou_list_area,parent,false))
            }
            TECH_NEWS -> {
                HorizontalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_list_area,parent,false))
            }
            SPORT_NEWS -> {
                HorizontalNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_list_area,parent,false))
            }
            SHUFFLE_NEWS -> {
                ShuffleViewHolder(LayoutInflater.from(context).inflate(R.layout.shuffle_news_list_area,parent,false))
            }


            else -> ShuffleViewHolder(LayoutInflater.from(context).inflate(R.layout.shuffle_news_list_area,parent,false))
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)){
            TOP_NEWS -> {
                val horizontalNewsViewHolder : HorizontalNewsViewHolder = holder as HorizontalNewsViewHolder
                horizontalNewsViewHolder.haveFunWithView(context,getArticlesByPosition(position),"Top News")
            }
            FOR_YOU -> {
                val verticalNewsViewHolder : VerticalNewsViewHolder = holder as VerticalNewsViewHolder
                verticalNewsViewHolder.initiateVerticalViewHolder(context,getArticlesByPosition(position))
            }
            TECH_NEWS -> {
                val horizontalViewHolder : HorizontalNewsViewHolder = holder as HorizontalNewsViewHolder
                horizontalViewHolder.haveFunWithView(context,getArticlesByPosition(position),"Technology News")
            }
            SPORT_NEWS -> {
                val horizontalViewHolder : HorizontalNewsViewHolder = holder as HorizontalNewsViewHolder
                horizontalViewHolder.haveFunWithView(context,getArticlesByPosition(position),"Sport News")
            }
            SHUFFLE_NEWS -> {
                val  shuffleViewHolder : ShuffleViewHolder = holder as ShuffleViewHolder
                shuffleViewHolder.setArticles(context,getArticlesByPosition(position))
            }


            else ->  {
                val  shuffleViewHolder : ShuffleViewHolder = holder as ShuffleViewHolder
                shuffleViewHolder.setArticles(context,getArticlesByPosition(position))
            }

        }

    }

    fun getArticlesByPosition(position : Int) : List<Articles>{
        val  mainNews : MainNews = newsList[position]
        return mainNews.articles!!
    }








}