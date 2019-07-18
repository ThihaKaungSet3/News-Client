package com.example.newsclient.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.ui.viewholder.CategoriesItemViewHolder
import com.example.newsclient.ui.viewholder.HorizontalNewsItemViewHolder
import com.example.newsclient.ui.viewholder.VerticalNewsItemViewHolder

class NewsAdapter(context: Context?,orientation : Int,categories: Array<String> ?= null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val TAG = "NewsAdapter"
        private const val VERTICAL = 0
        private const val HORIZONTAL = 1
        private const val DESIRE_DATASET = 6
        private const val CATEGORIES = 69
    }

    private var context: Context? = context
    private var orientation : Int = orientation
    private lateinit var articles : List<Articles>
    private var categories: Array<String> ?= categories

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(TAG,"onCreate")
        return when(orientation){
            VERTICAL -> VerticalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_news_item,parent,false))
            HORIZONTAL -> HorizontalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_news_item,parent,false))
            CATEGORIES -> CategoriesItemViewHolder(LayoutInflater.from(context).inflate(R.layout.categories_item,parent,false))


            else -> VerticalNewsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_news_item,parent,false))
        }
    }


    fun setArticleLists(articles: List<Articles>){
        Log.d(TAG,"setArticle")
        this.articles = articles
        notifyDataSetChanged()
    }

//    fun setCategoriesList(categories : Array<String>){
//        Log.d(TAG,"setCategories")
//        this.categories = categories
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        Log.d(TAG, "Get Item count")
        if (orientation == VERTICAL || articles.size <= 6) {
            Log.d(TAG,"vertical")
            return articles.size
        }else if (articles.size > 6) {
            Log.d(TAG,"Desiredataset")
            return DESIRE_DATASET
        }else if (orientation == CATEGORIES){
            return categories?.size!!
        }
        return articles.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder")
        var article : Articles = articles[position]

        when(orientation){
            VERTICAL -> {
                val verticalNewsItem :  VerticalNewsItemViewHolder = holder as VerticalNewsItemViewHolder
                verticalNewsItem.havefunwithViews(article)
            }
            HORIZONTAL -> {
                val horizontalNewsItem : HorizontalNewsItemViewHolder = holder as HorizontalNewsItemViewHolder
                when(position) {
                    5 -> horizontalNewsItem.showSeeAll()
                    else -> horizontalNewsItem.dancingwithViews(article)
                }
            }
            CATEGORIES -> {
                val categoriesItem : CategoriesItemViewHolder = holder as CategoriesItemViewHolder
                val category  = categories?.get(position)
                categoriesItem.summonCategoryJob(category)

            }
        }

    }

}

