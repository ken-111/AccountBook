package com.example.accountbook.viewmodel



import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.accountbook.reference.GlobalDateAccount
import com.example.accountbook.repository.AccountBookRepository
import java.security.AccessController.getContext

class TopViewModel():ViewModel(){


    /**今日の収支**/
    private val _moneyToday=showAmountToday()
    val moneyToday:String=_moneyToday

    /**InputPageに遷移する値**/
    private val _toInputPage=MutableLiveData<Boolean>()
    val toInputPage:LiveData<Boolean> = _toInputPage

     val explainText="今日の収支は"
     val buttonText="入力する"

    /**
     * 今日の収支報告
     * ＠return String
     */
    private fun showAmountToday():String{
        val globalTodayMoney = GlobalDateAccount.getInstance().globalMoney

        return globalTodayMoney.toString()
    }


     fun moveToInputPage(){

        _toInputPage.value=true

    }

}


