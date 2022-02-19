package com.example.accountbook.reference

import android.app.Application
import com.example.accountbook.model.AccountModel
import java.util.Collections.list

class GlobalAccountModelData: Application() {

    /**
     * グローバル変数
     */
    var allAccountModelList =  arrayListOf<AccountModel>()

    /**
     * シングルトンインスタンスの生成。全てのクラスはこのインスタンスを用いる
     */
    companion object {
        private var instance: GlobalAccountModelData? = null

        fun getInstance(): GlobalAccountModelData {
            if (instance == null) instance = GlobalAccountModelData()
            return instance!!
        }
    }
}