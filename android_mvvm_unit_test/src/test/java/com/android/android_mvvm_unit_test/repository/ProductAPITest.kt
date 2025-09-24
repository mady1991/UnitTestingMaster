package com.android.android_mvvm_unit_test.repository

import com.android.android_mvvm_unit_test.api.ProductsAPI
import com.android.android_mvvm_unit_test.utils.NetworkResult
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.Test

class ProductAPITest {

    lateinit var mockWebServer: MockWebServer
    lateinit var apiService: ProductsAPI


    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductsAPI::class.java)
    }

    @Test
    fun testGetProducts_EmptyList() = runTest {
        val mockResponse = MockResponse()
        mockWebServer.enqueue(
            mockResponse
                .setResponseCode(404)
        )
        val sut = ProductRepository(apiService)
        val result = sut.getProducts()
        val request = mockWebServer.takeRequest()

        Assert.assertEquals(true, result is NetworkResult.Success)
        Assert.assertEquals(0, result.data!!.size)
    }

}