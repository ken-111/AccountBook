package com.example.accountbook.viewmodel

import android.util.Log
import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.accountbook.model.ListItemModel
import com.example.accountbook.reference.GlobalAccountModelData

class DateViewModel(date:String):ViewModel() {

    private val selectedDate = date

    private val listItemModel = mutableListOf<ListItemModel>()

    private val _dataList = MutableLiveData<List<ListItemModel>>()

    val dataList: LiveData<List<ListItemModel>> = _dataList

init{
    addList()
}

    private fun addList(){

        val globalData = GlobalAccountModelData.getInstance().allAccountModelList

        var showListData = globalData.filter { selectedDate.contains(it.date) }

        var cnt = 0
        showListData.forEach { i ->

            listItemModel.add(ListItemModel(cnt.toLong(),i.money.toString(),i.category))
            cnt++

        }

         _dataList.value = listItemModel

    }

    fun onClickItem(category:String,money:String){



    }
}