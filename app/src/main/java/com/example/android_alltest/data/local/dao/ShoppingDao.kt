package com.example.android_alltest.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_alltest.data.local.entity.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun observableAllShoppingItems(): LiveData<List<ShoppingItem>>

    @Query("SELECT SUM (price * amount) FROM  shopping_items")
    fun observableTotalPrice(): LiveData<Float>

}