package com.example.accountbook.viewmodel

import android.util.Log
import android.widget.CalendarView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalendarViewModel: ViewModel() {

    private val _onClickDate= MutableLiveData<String>()
    val onClickDate: LiveData<String> = _onClickDate

    /**
     * カレンダービューのタップイベント
     * カレンダービュータップされた日付を取得
     */
    fun getDate(calendarView: CalendarView, year: Int, month: Int, dayOfMonth: Int){

        var inputMonth = ""
        if(month+1<10){
            inputMonth = "0" + (month+1)
        }else if(month==12){
            inputMonth = month.toString()
        }else{
            inputMonth = (month+1).toString()
        }

        _onClickDate.value = "$year-$inputMonth-$dayOfMonth"

    }

}