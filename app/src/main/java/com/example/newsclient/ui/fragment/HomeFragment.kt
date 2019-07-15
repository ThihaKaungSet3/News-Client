package com.example.newsclient.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsclient.R
import com.example.newsclient.data.Articles
import com.example.newsclient.data.MainNews
import com.example.newsclient.data.Sources
import com.example.newsclient.ui.adapter.MainAdapter


class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findViews(view)

        setupRecyclerView()
    }


    /**
     * Manually set List of Top News
     * will be use NewsAPI for that
     */
    fun getTopNewsList() : List<Articles>{

        val topnewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth")

        )



        return topnewsList
    }



    fun getTechNewsList() : List<Articles>{

        val techNewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"))
        Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
            ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth")

        return techNewsList
    }



    fun getSportNewsList() : List<Articles>{

        val sportNewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"))
        Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
            ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth")

        return sportNewsList
    }



    fun getShuffleNewsList() : List<Articles>{

        val shuffleNewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://tribktla.files.wordpress.com/2019/07/oil.jpg?quality=85&strip=all&w=1200","","","Smth"))
        Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
            ,"https://g.foolcdn.com/editorial/images/530678/getty-senior-regrets-unhappy-mad-retiree-mistakes.jpg","","","Smth")

        return shuffleNewsList
    }



    private fun setupRecyclerView(){

        val mainNewsList  = listOf<MainNews>(MainNews("top",getTopNewsList()),
                                            MainNews("tech",getTechNewsList()),
                                            MainNews("sport",getSportNewsList()),
                                            MainNews("shuffle",getShuffleNewsList())
                                            )

        val mainAdapter  = MainAdapter(context,mainNewsList)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mainAdapter


    }


    private fun findViews(view: View){
        recyclerView = view.findViewById(R.id.home_recycler)
    }


}
