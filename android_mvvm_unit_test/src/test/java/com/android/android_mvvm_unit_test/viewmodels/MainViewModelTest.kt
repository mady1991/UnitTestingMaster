package com.android.android_mvvm_unit_test.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.State
import com.android.android_mvvm_unit_test.getOrAwaitValue
import com.android.android_mvvm_unit_test.repository.ProductRepository
import com.android.android_mvvm_unit_test.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_GetProducts() = runTest{
        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Success(emptyList()))

        val sut = MainViewModel(repository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.products.getOrAwaitValue()
        Assert.assertEquals(0, result.data!!.size)
    }

    @Test
    fun test_GetProduct_expectedError() = runTest{
        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Error("Something Went Wrong"))

        val sut = MainViewModel(repository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.products.getOrAwaitValue()
        Assert.assertEquals(true, result is NetworkResult.Error)
        Assert.assertEquals("Something Went Wrong", result.message)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}