package com.inito.assignmentaugweek2.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://www.inito.com/products/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ProductApiService {
    @GET("list")
    suspend fun getProductData(): ProductData
}

object ProductApi {
    val retrofitService: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }
}