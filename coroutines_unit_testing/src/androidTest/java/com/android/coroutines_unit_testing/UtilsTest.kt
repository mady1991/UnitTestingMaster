package com.android.coroutines_unit_testing

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilsTest {

    @get:Rule
    val mainCoroutineRule: MainCoroutineRule = MainCoroutineRule()


    @Test
    fun testUserName() {
        val SUT = Utils(mainCoroutineRule.testDispatcher)
        /* By this way we can't avoid delay in test case*/
        runBlocking {
            val result = SUT.getUserName()
            assertEquals("mady1991", result)
        }
    }

    @Test
    fun testCoroutinesGetUser() {
        val SUT = Utils(mainCoroutineRule.testDispatcher)
        /* By this way we can avoid delay in test case*/
        runTest {
            val result = SUT.getUserName()
            assertEquals("mady1991", result)
        }

    }

    @Test
    fun tes_getUser() {
        val SUT = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            SUT.getUser()
        }
    }

    @Test
    fun test_getAddress() {
        val SUT = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            val result = SUT.getAddress()
            assertEquals("World", result)
        }
    }

    @Test
    fun test_getAddressDetail() {
        val SUT = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            SUT.getAddressDetail()
            //This below statement will behave like await in java
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(true, SUT.globaArgs)
        }
    }



}