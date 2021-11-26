package com.example.android_alltest.domain.repository

import androidx.lifecycle.LiveData
import com.example.android_alltest.data.local.entity.ShoppingItem
import com.example.android_alltest.data.remote.response.ImageResponse
import com.example.android_alltest.data.util.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}