package com.example.android_alltest.data.remote.datasource

import com.example.android_alltest.data.remote.response.ImageResponse
import com.example.android_alltest.data.util.Utils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = Utils.key
    ): Response<ImageResponse>
}