package com.wayeal.jetpackdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.wayeal.jetpackdemo.databinding.ItemStudentLayoutBinding

class StudentAdapter(mStudentList: List<Student>, mContext: Context) :
    BaseAdapter() {

    private val studentList = mStudentList
    private val context: Context? = mContext

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemStudentLayoutBinding: ItemStudentLayoutBinding? = null
        if (p1 == null) {
            itemStudentLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context)
                , R.layout.item_student_layout
                , p2
                , false
            )
        } else {
            itemStudentLayoutBinding = DataBindingUtil.getBinding(p1)
        }
        itemStudentLayoutBinding?.student = studentList[p0]
        return itemStudentLayoutBinding?.root!!
    }

    override fun getItem(p0: Int): Any {
        return studentList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return studentList.size
    }
}