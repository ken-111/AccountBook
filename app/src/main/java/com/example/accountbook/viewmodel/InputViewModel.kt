package com.example.accountbook.viewmodel


import android.app.Application
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.accountbook.model.AccountModel
import com.example.accountbook.model.CategoryModel
import com.example.accountbook.reference.DefineConstName.Companion.BONUS_CATEGORY
import com.example.accountbook.reference.DefineConstName.Companion.DAILY_CATEGORY
import com.example.accountbook.reference.DefineConstName.Companion.EDUCATION_CATEGORY
import com.example.accountbook.reference.DefineConstName.Companion.FOOD_CATEGORY
import com.example.accountbook.reference.DefineConstName.Companion.INCOME_CATEGORY
import com.example.accountbook.reference.DefineConstName.Companion.RESIDENCE_CATEGORY
import com.example.accountbook.reference.GlobalDateAccount
import com.example.accountbook.reference.GlobalSetting
import com.example.accountbook.repository.AccountBookRepository
import com.example.accountbook.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class InputViewModel(application: Application) : AndroidViewModel(application) {

    val buttonText = "入力する"

    val moneyText = "金額"

    val categoryText = "カテゴリー"

    /**入力された金額**/
    var money:String = ""

    /**選択されたカテゴリー**/
    private var categoryPosition:Int=0

    /**入力後TopPageに戻るように判定する値**/
    private val _toTopPage= MutableLiveData<Boolean>()
    val toTopPage: LiveData<Boolean> = _toTopPage

    private val myApplication = application

    private val accountBookRepository = AccountBookRepository(myApplication)

    private val categoryRepository = CategoryRepository(myApplication)

    private val categoryList = arrayListOf<String>(FOOD_CATEGORY,RESIDENCE_CATEGORY,EDUCATION_CATEGORY,DAILY_CATEGORY,INCOME_CATEGORY,BONUS_CATEGORY)


    val clicksListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            categoryPosition=position
        }
    }

    fun insertAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            val globalDate = GlobalDateAccount.getInstance().globalToday
            val accountModel=AccountModel(0,money.toInt(),globalDate,categoryList[categoryPosition])
            accountBookRepository.insertAccount(accountModel)
        }

        insertCategoryData()

        val globalSetting = GlobalSetting(myApplication)
        globalSetting.settingGlobalVariable()

        _toTopPage.value=true

    }

    private fun insertCategoryData() {
        viewModelScope.launch(Dispatchers.IO) {

         val categoryModel = CategoryModel(categoryList[categoryPosition],money.toInt())
            categoryRepository.insertCategoryData(categoryModel)

        }

    }
}