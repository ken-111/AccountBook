package com.example.accountbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.accountbook.reference.DefineConstName.Companion.ACCOUNT_TABLE

@Entity(tableName = ACCOUNT_TABLE)
data class AccountModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "money")  val money: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "category") val category:String) {}