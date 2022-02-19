package com.example.accountbook.reference

import android.app.Application
import com.example.accountbook.model.AccountModel
import com.example.accountbook.model.CategoryModel

class GlobalCategoryModelData:Application() {

    /**
     * グローバル変数
     */
    var allCategoryModelList =  arrayListOf<CategoryModel>()

    /**
     * シングルトンインスタンスの生成。全てのクラスはこのインスタンスを用いる
     */
    companion object {
        private var instance: GlobalCategoryModelData? = null

        fun getInstance(): GlobalCategoryModelData {
            if (instance == null) instance = GlobalCategoryModelData()
            return instance!!
        }
    }
}