package com.example.accountbook.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.accountbook.model.AccountModel
import com.example.accountbook.model.AccountBookDao
import com.example.accountbook.model.CategoryModelDao
import com.example.accountbook.model.CategoryModel
import com.example.accountbook.reference.DefineConstName.Companion.DB_VERSION


@Database(entities = [AccountModel::class, CategoryModel::class], version = DB_VERSION)
abstract class AccountBookDB : RoomDatabase() {
    abstract fun accountBookDao(): AccountBookDao
    abstract fun categoryModelDao(): CategoryModelDao
}