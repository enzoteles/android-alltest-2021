package com.example.android_alltest.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.android_alltest.data.local.dao.ShoppingDao
import com.example.android_alltest.data.local.database.ShoppingItemDataBase
import com.example.android_alltest.data.remote.datasource.PixabayApi
import com.example.android_alltest.data.repository.ShoppingRepositoryImpl
import com.example.android_alltest.data.util.Utils
import com.example.android_alltest.data.util.Utils.DATABASE_NAME
import com.example.android_alltest.domain.repository.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDataBase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: ShoppingDao,
        api: PixabayApi
    ) = ShoppingRepositoryImpl(dao, api) as ShoppingRepository

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDataBase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Utils.BASE_URL)
            .build()
            .create(PixabayApi::class.java)
    }
}