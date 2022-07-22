package com.example.android.dummyproductmanagement.api

import com.example.android.dummyproductmanagement.model.ProductListResponse
import retrofit2.Response

// ApiHelper will help it to be accessed via repository maintaining encapsulation
interface ApiHelper {
    suspend fun getProductList(): Response<ProductListResponse>
}