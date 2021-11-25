package com.example.android_alltest.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_alltest.data.local.dao.ShoppingDao
import com.example.android_alltest.data.local.entity.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDataBase: RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}