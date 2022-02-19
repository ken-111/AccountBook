@file:Suppress("DEPRECATION")
package com.example.accountbook.viewmodel

import androidx.databinding.BindingAdapter

import com.google.android.material.bottomnavigation.BottomNavigationView


object BottomNavBindingAdapter {
    @JvmStatic
    @BindingAdapter("onNavigationItemSelected")
    fun setOnNavigationItemSelectedListener(
        view: BottomNavigationView,
        listener: BottomNavigationView.OnNavigationItemSelectedListener?
    ) {
        view.setOnNavigationItemSelectedListener(listener)
    }
}


