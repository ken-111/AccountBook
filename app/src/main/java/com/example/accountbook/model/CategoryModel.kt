package com.example.accountbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.accountbook.reference.DefineConstName

@Entity(tableName = DefineConstName.CATEGORY_TABLE)
data class CategoryModel(
    @PrimaryKey @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "money")  val money: Int)
{}