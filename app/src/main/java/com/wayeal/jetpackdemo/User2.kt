package com.wayeal.jetpackdemo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class User2 : BaseObservable(){

    @get:Bindable
    var name:String = ""
        set(value)  {
            field = value
            notifyPropertyChanged(BR.name)
        }

    //一定要加注解 同时在gradle离配置
}