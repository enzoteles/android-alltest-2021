package com.example.android_alltest.data.remote.response

data class ImageResponse(
    val hits: List<HitResponse>,
    val total: Int,
    val totalHits: Int
)