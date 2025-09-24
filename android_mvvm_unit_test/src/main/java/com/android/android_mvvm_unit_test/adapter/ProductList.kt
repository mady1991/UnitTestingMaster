package com.android.android_mvvm_unit_test.adapter

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.android.android_mvvm_unit_test.models.ProductListItem

@Composable
fun ProductList(products: List<ProductListItem>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product)
        }
    }
}