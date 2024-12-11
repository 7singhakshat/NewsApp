package com.example.newsapp.data.ApiBuilder

import com.example.newsapp.data.apiService.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {
    fun retrofitObject(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .create(ApiService::class.java)
            .build()
        return retrofit
    }
}