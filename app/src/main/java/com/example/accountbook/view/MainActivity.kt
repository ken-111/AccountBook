package com.example.accountbook.view

import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.accountbook.DB.AccountBookDB
import com.example.accountbook.R
import com.example.accountbook.databinding.ActivityMainBinding
import com.example.accountbook.reference.DefineConstName
import com.example.accountbook.reference.GlobalSetting
import com.example.accountbook.viewmodel.BottomNavigationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext as CoroutineContext


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val bottomNavigation = BottomNavigationViewModel()
        binding.viewModel = bottomNavigation

        //起動時に入力ページへ遷移
        if (savedInstanceState == null) {

            val globalSetting = GlobalSetting(applicationContext)
            globalSetting.settingGlobalVariable()

            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TopFragment())
                    .commitNow()

        }



        //BottomNavigationのボタンクリックを監視
        bottomNavigation.selectPageNum.observe(this, { it ->

           nextPage(it)

        })
    }

    /**
     * 引数によって遷移するページのインスタンスを戻す関数
    **/
    fun nextPage(id: Int?){
        var nextFragment = Fragment()
        when (id) {
            DefineConstName.CALENDAR_FRAGMENT -> {
                nextFragment = CalendarFragment()
            }
            DefineConstName.TOP_FRAGMENT -> {
                nextFragment = TopFragment()
            }
            DefineConstName.GRAPH_FRAGMENT -> {
                nextFragment = GraphFragment()
            }
            DefineConstName.INPUT_FRAGMENT -> {
                nextFragment =InputFragment()
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, nextFragment)
            .commitNow()
    }


    /**
     * DateFragmentへ遷移するページのインスタンスを戻す関数
     **/
    fun toDatePage(selectDate:String){
        val dateFragment =DateFragment(selectDate)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, dateFragment)
            .commitNow()
    }
}


