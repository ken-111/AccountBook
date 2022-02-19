package com.example.accountbook.viewmodel

import android.widget.CalendarView
import androidx.databinding.BindingAdapter

object CalendarViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:date")
    fun selectedDate(view: CalendarView, date: Long) {
        if (view.date != date) {
            view.date = date
        }
    }
    @JvmStatic
    @BindingAdapter("android:onSelectedDayChange")
    fun setOnDateChangeListener(view: CalendarView,listener: CalendarView.OnDateChangeListener?){
        view.setOnDateChangeListener(listener)
    }
}
