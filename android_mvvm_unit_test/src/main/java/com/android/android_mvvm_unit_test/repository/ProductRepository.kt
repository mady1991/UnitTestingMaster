package com.android.android_mvvm_unit_test.repository

import com.android.android_mvvm_unit_test.api.ProductsAPI
import com.android.android_mvvm_unit_test.models.ProductListItem
import com.android.android_mvvm_unit_test.utils.NetworkResult

class ProductRepository(private val productsAPI: ProductsAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productsAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}