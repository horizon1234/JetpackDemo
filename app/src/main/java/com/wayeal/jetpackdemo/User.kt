package com.wayeal.jetpackdemo

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField

class User{

    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()

    fun print(view:View){
        Log.i("zyh", "print: click")
    }

    fun print1(){
        Log.i("zyh", "print1: ")
    }
}