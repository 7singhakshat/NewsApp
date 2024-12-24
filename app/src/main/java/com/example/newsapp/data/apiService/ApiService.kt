package com.example.newsapp.data.apiService

import com.example.newsapp.data.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    fun getHeadLines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String="e989a67088104ddea95e9dbf1347fc3d"
    ): ApiResponse


}

