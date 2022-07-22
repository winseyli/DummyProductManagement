package com.example.android.dummyproductmanagement.api

import com.example.android.dummyproductmanagement.model.ProductListResponse
import retrofit2.Response
import javax.inject.Inject

// ApiHelperImpl will be the class which will implement ApiHelper to provide functionality to ApiHelper functions
class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
): ApiHelper {
    override suspend fun getProductList(): Response<ProductListResponse> = apiService.getProductList()
}