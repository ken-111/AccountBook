package com.example.accountbook.reference

import android.app.Application

class GlobalDateAccount : Application() {
    /**
     * グローバル変数。
     */
    var globalMoney : Int= 0

    var globalToday:String = ""
    /**
     * シングルトンインスタンスの生成。全てのクラスはこのインスタンスを用いる。
     */
    companion object {
        private var instance: GlobalDateAccount? = null

        fun getInstance(): GlobalDateAccount {
            if (instance == null) instance = GlobalDateAccount()
            return instance!!
        }
    }
}