package com.android.android_mvvm_unit_test.api

import com.android.android_mvvm_unit_test.models.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductsAPI {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductListItem>>

}