package com.android.android_mvvm_unit_test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.android.android_mvvm_unit_test.adapter.ProductItem
import com.android.android_mvvm_unit_test.ui.theme.Android_unit_testing_masterTheme
import com.android.android_mvvm_unit_test.utils.NetworkResult
import com.android.android_mvvm_unit_test.viewmodels.MainViewModel
import com.android.android_mvvm_unit_test.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        )[MainViewModel::class.java]

        mainViewModel.getProducts()

        setContent {
            Android_unit_testing_masterTheme {
                ProductScreen(mainViewModel)
            }
        }
    }
}

@Composable
fun ProductScreen(viewModel: MainViewModel) {
    val productState = viewModel.products.observeAsState()

    when (val result = productState.value) {
        is NetworkResult.Success -> {
            LazyColumn {
                items(result.data ?: emptyList()) { product ->
                    ProductItem(product)
                }
            }
        }
        is NetworkResult.Error -> {
            Log.e("CHEEZ", "Error: ${result.message}")
            // You can also show an error UI here
        }
        else -> {
            // Maybe show a Loading UI here
        }
    }
}