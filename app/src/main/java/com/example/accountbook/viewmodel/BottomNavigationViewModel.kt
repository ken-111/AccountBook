package com.example.accountbook.viewmodel

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.accountbook.R
import com.example.accountbook.reference.DefineConstName.Companion.CALENDAR_FRAGMENT
import com.example.accountbook.reference.DefineConstName.Companion.GRAPH_FRAGMENT
import com.example.accountbook.reference.DefineConstName.Companion.TOP_FRAGMENT

class BottomNavigationViewModel {
    private val _selectPageNum = MutableLiveData<Int>()
    val selectPageNum: LiveData<Int> = _selectPageNum

    /**
     * ボトムナビゲーションのタップイベント
     * MainActivityがObserveするselectPageNumの値によって遷移するページを切り分け
     * @return Boolean
     */

    fun onBottomMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_calendar -> {
                _selectPageNum.value = CALENDAR_FRAGMENT
                return true
            }
            R.id.nav_input -> {
                _selectPageNum.value = TOP_FRAGMENT
                return true
            }
            R.id.nav_data -> {
                _selectPageNum.value = GRAPH_FRAGMENT
                return true
            }

        }
        return false
    }
}