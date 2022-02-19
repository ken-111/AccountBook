package com.example.accountbook.repository

import android.content.Context
import androidx.room.Room
import com.example.accountbook.DB.AccountBookDB
import com.example.accountbook.model.AccountModel
import com.example.accountbook.model.CategoryModel
import com.example.accountbook.reference.DefineConstName

class CategoryRepository (context: Context){

    val app = context

    fun insertCategoryData(categoryModel: CategoryModel){
        val database =
            Room.databaseBuilder(app, AccountBookDB::class.java, DefineConstName.DB_NAME)
                .build()
        val categoryDao = database.categoryModelDao()

        if(categoryModel.category == DefineConstName.INCOME_CATEGORY || categoryModel.category == DefineConstName.BONUS_CATEGORY) {
            categoryDao.insert(categoryModel)
        }else {
            val categoryModel = CategoryModel(
                categoryModel.category,
                -categoryModel.money
            )
            categoryDao.insert(categoryModel)
        }
    }

    fun getReadData():List<CategoryModel>{

        val database =
            Room.databaseBuilder(app, AccountBookDB::class.java, DefineConstName.DB_NAME)
                .build()

        val categoryDao = database.categoryModelDao()
        return categoryDao.select()

    }
}