package com.example.newsapp

import com.example.newsapp.data.ApiBuilder.ApiBuilder
import com.example.newsapp.data.model.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class NewRepo {
    val apiInstance = ApiBuilder.retrofitObject()

    suspend fun getHeadLine(country: String = "us"): Flow<ApiState> {
        return flow {
            emit(ApiState(loading = true))
            try {
                val response = apiInstance.getHeadLines(country = country)
                emit(ApiState(data = response))
            } catch (e: HttpException) {
                emit(ApiState(error = e.localizedMessage))
            } catch (e: Exception) {
                emit(ApiState(error = e.localizedMessage))
            }
        }

    }


    suspend fun getEverything(q: String = "us"): Flow<ApiState> {
        return flow {
            emit(ApiState(loading = true))
            try {
                val response = apiInstance.getEverything(q = q)
                emit(ApiState(data = response))
            } catch (e: HttpException) {
                emit(ApiState(error = e.localizedMessage))
            } catch (e: Exception) {
                emit(ApiState(error = e.localizedMessage))
            }
        }


    }
}
 class ApiState(
    var loading : Boolean? = false,
    var error : String? = "",
    var data : ApiResponse?= null
)