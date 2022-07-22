package com.example.android.dummyproductmanagement.model

data class ProductListResponse (
    val products: List<Product>? = null,
    val total: Int? = null
)