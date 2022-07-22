package com.example.android.dummyproductmanagement

import com.example.android.dummyproductmanagement.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getProductList() = apiHelper.getProductList()
}