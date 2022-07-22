package com.example.android.dummyproductmanagement.api

import com.example.android.dummyproductmanagement.model.ProductListResponse
import retrofit2.Response
import retrofit2.http.GET

// ApiService will service our network call
interface ApiService {

    @GET("products")
    suspend fun getProductList(): Response<ProductListResponse>
}