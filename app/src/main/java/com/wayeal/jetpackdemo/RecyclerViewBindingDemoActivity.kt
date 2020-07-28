package com.wayeal.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_view_binding_demo.*

class RecyclerViewBindingDemoActivity : AppCompatActivity() {

    private var mStudentList = ArrayList<Student>()
    private var mStudentAny:StudentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_binding_demo)

        for (index in 0..5){
            mStudentList.add(Student("qqq",18,true))
        }

        mStudentAny = StudentAdapter(mStudentList,this)
        list_view.adapter = mStudentAny
    }
}