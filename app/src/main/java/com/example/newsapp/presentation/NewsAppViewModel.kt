package com.example.newsapp.presentation

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.ApiBuilder.ApiBuilder
import com.example.newsapp.data.model.ApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsAppViewModel : ViewModel(){
    val apiInstance= ApiBuilder.retrofitObject()
    private val _state = MutableStateFlow(AppState())
    private val state= _state.asStateFlow()

    fun getHeadLine(){
        _state.value= AppState(loading = true)

    }
}

data class AppState(
    var loading : Boolean? = false,
    var error : String? = "",
    var data : ApiResponse?= null
)