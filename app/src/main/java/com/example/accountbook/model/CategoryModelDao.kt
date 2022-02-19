package com.example.accountbook.model

import androidx.room.*
import com.example.accountbook.reference.DefineConstName

@Dao
interface CategoryModelDao {
    @Insert
    fun insert(categoryModel : CategoryModel)

    @Update
    fun update(categoryModel : CategoryModel)

    @Query("select * from ${DefineConstName.CATEGORY_TABLE}")
    fun select(): List<CategoryModel>

    @Delete
    fun delete(categoryModel : CategoryModel)
}