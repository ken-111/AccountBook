package com.example.accountbook.model

import androidx.room.*
import com.example.accountbook.model.AccountModel
import com.example.accountbook.reference.DefineConstName.Companion.ACCOUNT_TABLE

@Dao
interface AccountBookDao {

    @Insert
    fun insert(accountModel : AccountModel)

    @Update
    fun update(accountModel : AccountModel)

    @Query("select * from $ACCOUNT_TABLE")
    fun getAll(): List<AccountModel>

    @Delete
    fun delete(accountModel : AccountModel)
}