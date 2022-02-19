package com.example.accountbook.repository

import android.content.Context
import androidx.room.Room
import com.example.accountbook.DB.AccountBookDB
import com.example.accountbook.model.AccountModel
import com.example.accountbook.reference.DefineConstName.Companion.BONUS_CATEGORY
import com.example.accountbook.reference.DefineConstName.Companion.DB_NAME
import com.example.accountbook.reference.DefineConstName.Companion.INCOME_CATEGORY

class AccountBookRepository(context:Context){

    val app = context

    fun insertAccount(accountModel: AccountModel){
        val database =
            Room.databaseBuilder(app, AccountBookDB::class.java, DB_NAME)
                .build()
        val accountBookDao = database.accountBookDao()

        if(accountModel.category == INCOME_CATEGORY|| accountModel.category == BONUS_CATEGORY) {

            accountBookDao.insert(accountModel)
        }else {
            val accountModel = AccountModel(
                accountModel.id,
                -accountModel.money,
                accountModel.date,
                accountModel.category
            )
            accountBookDao.insert(accountModel)
        }
    }

     fun getReadData():List<AccountModel>{

            val database =
                Room.databaseBuilder(app, AccountBookDB::class.java, DB_NAME)
                    .build()

            val accountBookDao = database.accountBookDao()

            return accountBookDao.getAll()

     }
}