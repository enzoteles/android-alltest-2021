package com.example.android_alltest.data.repository

import androidx.lifecycle.LiveData
import com.example.android_alltest.data.local.dao.ShoppingDao
import com.example.android_alltest.data.local.entity.ShoppingItem
import com.example.android_alltest.data.remote.datasource.PixabayApi
import com.example.android_alltest.data.remote.response.ImageResponse
import com.example.android_alltest.data.util.Resource
import com.example.android_alltest.domain.repository.ShoppingRepository

class ShoppingRepositoryImpl(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayApi
): ShoppingRepository{

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observableAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observableTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            } else {
                Resource.error("An unknown error occured", null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't reach the server. Check your internet connection", null)
        }
    }
}