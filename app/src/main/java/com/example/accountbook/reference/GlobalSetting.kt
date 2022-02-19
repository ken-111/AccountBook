package com.example.accountbook.reference

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.accountbook.model.AccountModel
import com.example.accountbook.model.CategoryModel
import com.example.accountbook.repository.AccountBookRepository
import com.example.accountbook.repository.CategoryRepository
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.coroutines.CoroutineContext

class GlobalSetting(context: Context) {

     private val myApp = context

    fun settingGlobalVariable()= runBlocking{

            /**DB読み出し処理のため非同期処理 **/
        withContext(Dispatchers.IO) {

            setGlobalAccountModelData()

            setGlobalCategoryModelData()

            setGlobalDateAccount()
        }

    }

    /**
     * GlobalAccountModelDataを設定
     * ＠return
     */
    private fun setGlobalAccountModelData(){
        val globalAccountModelData = GlobalAccountModelData.getInstance()
        val accountBookRepository = AccountBookRepository(myApp)
        globalAccountModelData.allAccountModelList= accountBookRepository.getReadData() as ArrayList<AccountModel>
    }

    /**
     * GlobalCategoryModelDataを設定
     * ＠return
     */

    private fun setGlobalCategoryModelData() {
        val globalCategoryModelData = GlobalCategoryModelData.getInstance()
        val categoryRepository = CategoryRepository(myApp)
        globalCategoryModelData.allCategoryModelList =
            categoryRepository.getReadData() as ArrayList<CategoryModel>
    }
    /**
     * GlobalDateAccountを設定
     * ＠return
     */
    private fun setGlobalDateAccount(){
        val globalAccountModelList = GlobalAccountModelData.getInstance().allAccountModelList
        val today = getToday()
        val todayList = globalAccountModelList.filter { today.contains(it.date) }
        var todayAmount = 0
        for (element in todayList) {
            todayAmount += element.money
        }
        var globalDateAccount = GlobalDateAccount.getInstance()
        globalDateAccount.globalMoney = todayAmount
        globalDateAccount.globalToday = today
    }

    /**
     * 日付を取得
     * ＠return　
     */
    fun getToday(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ISO_DATE
        return current.format(formatter)
    }
}