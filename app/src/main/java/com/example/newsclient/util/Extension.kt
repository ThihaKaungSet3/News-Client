package com.example.newsclient.util

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.newsclient.BuildConfig

fun Activity.logd(message : String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName,message)
}

fun Context.toast(message : String) = Toast.makeText(this,message,Toast.LENGTH_LONG).show()