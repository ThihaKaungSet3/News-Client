package com.example.newsclient.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.newsclient.R
import com.example.newsclient.util.logd
import com.example.newsclient.util.toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var navController: NavController

    companion object{
        const val TAG = "MainActivity"
    }


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findView()

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

            bottomNav.setOnNavigationItemSelectedListener { menuItem ->
                when(menuItem.itemId){
                    R.id.home -> {
                        navController.navigate(R.id.homeFragment)
                        toast("Home")}
                    R.id.bookmark -> {
                        navController.navigate(R.id.bookmarkFragment)
                        toast("Bookmark")
                    }
                }
                return@setOnNavigationItemSelectedListener true
            }

    }


    private fun findView(){
        bottomNav = findViewById(R.id.myonlyBottomNav)
    }


    override fun onBackPressed() {
        finish()
    }

}

