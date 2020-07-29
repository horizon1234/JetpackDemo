package com.wayeal.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import com.wayeal.jetpackdemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 方法一 该行代码做了3件事
         * 1、把布局设置给Activity，填充为view树
         * 2、创建Binding类对象
         * 3、把view保存在Binding类的成员中，绑定view
         * 这种方式只适合用于activity中
         * */
//        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        binding.user = User("TEST","USER")

        /**
         * 方法二
         * 1、inflate会填充MainActivityBinding对应的布局
         * 2、创建MainaActivityBinding对象，把布局和MainActivityBinding对象绑定起来
         * 3、如果要显示出该view，必须调用setContentView来加载布局
         * */
        val binding1 = ActivityMainBinding.inflate(layoutInflater)
        val tmpUser = User()
        tmpUser.firstName.set("first")
        tmpUser.lastName.set("last")
        binding1.user = tmpUser
        setContentView(binding1.root)

        val tmpUser1 = ObservableArrayMap<String,String>()
        tmpUser1.put("key","value")
        binding1.user1 = tmpUser1

        button.setOnClickListener{
            tmpUser.firstName.set("11111")
            tmpUser.lastName.set("22222")
        }

        val tmpUser2 = User2()
        tmpUser2.name = "haha"
        binding1.user2 = tmpUser2

        button2.setOnClickListener {
            tmpUser2.name = "uuuu"
        }

        /**
         * 综合分析，肯定第二种方法更好，第二种方法做的操作就是创建Binding对象，同时inflate出对应
         * 布局，然后和binding绑定起来
         * 比如在fragment、recyclerView适配器中使用数据绑定项，就用这种方法
         *  val listItemBinding = ListItemBinding
         *      .inflate(layoutInflater,R.layout.list_item,viewGoup,false)
         * */

        user_lastName.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }
        })
    }
}