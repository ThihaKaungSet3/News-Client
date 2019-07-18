package com.example.newsclient.ui.fragment


import android.content.res.Resources
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
import com.example.newsclient.util.Constants

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
            Articles(Sources(0,"Lifehacker.com"),"Use MSG to Improve Airplane Food "
                ,"https://i.kinja-img.com/gawker-media/image/upload/s--f5oKt94t--/c_fill,fl_progressive,g_center,h_900,q_80,w_1600/yh9cyj40n5byu3gzmdus.jpg","","","Smth"),
            Articles(Sources(0,"Engadget"),"The best GPS running watches for 2019"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"26 Best Amazon Prime Day Alternative Deals From Walmart, eBay, Etc"
                ,"https://media.wired.com/photos/5d2d184227e4ed0008704ea7/191:100/pass/Gear-PrimeDay-KitchenAid-Nespresso-Maker-SOURCE-KitchenAid.jpg","","","Smth")
        )

        return topnewsList
    }




    fun getTechNewsList() : List<Articles>{

        val techNewsList = listOf<Articles>(
            Articles(Sources(0,"TechCrunch"),"Apple reportedly planning to fund creation of exclusive original podcasts"
                ,"https://techcrunch.com/wp-content/uploads/2019/07/apple-podcasts-mac.png?w=690","","","Smth"),
            Articles(Sources(0,"BBC"),"AI photo editor FaceApp goes viral again on iOS, raises questions about photo library access"
                ,"https://techcrunch.com/wp-content/uploads/2017/08/p1050609.jpg?w=598","","","Smth"),
            Articles(Sources(0,"BBC"),"iOS and Android are about to get a bunch of new emoji"
                ,"https://techcrunch.com/wp-content/uploads/2019/07/android-q.png?w=764","","","Smth"),
            Articles(Sources(0,"TechCrunch"),"Apple reportedly planning to fund creation of exclusive original podcasts"
                ,"https://techcrunch.com/wp-content/uploads/2019/07/apple-podcasts-mac.png?w=690","","","Smth"),
            Articles(Sources(0,"BBC"),"AI photo editor FaceApp goes viral again on iOS, raises questions about photo library access"
                ,"https://techcrunch.com/wp-content/uploads/2017/08/p1050609.jpg?w=598","","","Smth"),
            Articles(Sources(0,"BBC"),"iOS and Android are about to get a bunch of new emoji"
                ,"https://techcrunch.com/wp-content/uploads/2019/07/android-q.png?w=764","","","Smth")

            )


        return techNewsList
    }



    fun getSportNewsList() : List<Articles>{

        val sportNewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth") ,
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
            ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
            ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
            ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth") ,
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
            ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth") ,
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook,"
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth") ,
            Articles(Sources(0,"BBC"),"Dow Jones Futures: Amazon Prime Day, Facebook, "
                ,"https://www.investors.com/wp-content/uploads/2019/06/stock-amazon-prime-day-01-shutter.jpg","","","Smth")
        )


        return sportNewsList
    }



    fun getShuffleNewsList() : List<Articles>{

        val shuffleNewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"OpenNIC drops support for.bit domain names after rampant malware abuse "
                ,"https://zdnet4.cbsistatic.com/hub/i/r/2018/03/20/6fa99fc2-3ecb-4638-a775-f8278486ff3c/thumbnail/770x578/f0453f40907c484238b54403754d5d05/screen-shot-2018-03-20-at-10-16-28.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Ripple Price (XRP) Holding Ground While Bitcoin Dived 15%"
                ,"https://www.newsbtc.com/wp-content/uploads/2018/01/Ripple_Price_XRP_USD_Analysis15.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Facebook’s libra could solve the gig economy’s payment problem"
                ,"https://www.cityam.com/assets/uploads/main-image/full_width_article_body_image/2015/03/facebook-mobiles-corbis-1024x640-57ed888707053-57ed888725e64.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"OpenNIC drops support for.bit domain names after rampant malware abuse "
                ,"https://zdnet4.cbsistatic.com/hub/i/r/2018/03/20/6fa99fc2-3ecb-4638-a775-f8278486ff3c/thumbnail/770x578/f0453f40907c484238b54403754d5d05/screen-shot-2018-03-20-at-10-16-28.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Ripple Price (XRP) Holding Ground While Bitcoin Dived 15%"
                ,"https://www.newsbtc.com/wp-content/uploads/2018/01/Ripple_Price_XRP_USD_Analysis15.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Facebook’s libra could solve the gig economy’s payment problem"
                ,"https://www.cityam.com/assets/uploads/main-image/full_width_article_body_image/2015/03/facebook-mobiles-corbis-1024x640-57ed888707053-57ed888725e64.jpg","","","Smth")

        )


        return shuffleNewsList
    }


    fun getForYouNews() : List<Articles>{

        val foryouNewsList = listOf<Articles>(
            Articles(Sources(0,"BBC"),"OpenNIC drops support for.bit domain names after rampant malware abuse "
                ,"https://zdnet4.cbsistatic.com/hub/i/r/2018/03/20/6fa99fc2-3ecb-4638-a775-f8278486ff3c/thumbnail/770x578/f0453f40907c484238b54403754d5d05/screen-shot-2018-03-20-at-10-16-28.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Ripple Price (XRP) Holding Ground While Bitcoin Dived 15%"
                ,"https://www.newsbtc.com/wp-content/uploads/2018/01/Ripple_Price_XRP_USD_Analysis15.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Facebook’s libra could solve the gig economy’s payment problem"
                ,"https://www.cityam.com/assets/uploads/main-image/full_width_article_body_image/2015/03/facebook-mobiles-corbis-1024x640-57ed888707053-57ed888725e64.jpg","","","Smth"),
            Articles(Sources(0,"BBC"),"Facebook’s libra could solve the gig economy’s payment problem"
                ,"https://www.cityam.com/assets/uploads/main-image/full_width_article_body_image/2015/03/facebook-mobiles-corbis-1024x640-57ed888707053-57ed888725e64.jpg","","","Smth")

        )

        return foryouNewsList
    }






    private fun setupRecyclerView(){

        val mainNewsList  = listOf<MainNews>(MainNews(Constants.TOP,getTopNewsList()),
                                            MainNews(Constants.FORYOU,getForYouNews()),
                                            MainNews(Constants.SPORT,getSportNewsList()),
                                            MainNews(Constants.SHUFFLE,getShuffleNewsList()),
                                            MainNews(Constants.TECH,getTechNewsList()),
                                            MainNews(Constants.SHUFFLE,getShuffleNewsList())
                                            )

        val mainAdapter  = MainAdapter(context,mainNewsList)


        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mainAdapter


    }


    private fun findViews(view: View){
        recyclerView = view.findViewById(R.id.home_recycler)
    }


}
