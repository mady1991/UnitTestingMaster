package com.android.instrumentation_test.non_ui

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PasswordVaildatorTest {
    lateinit var passwordVaildator: PasswordVaildator

    @Before
    fun setUp() {
        passwordVaildator = PasswordVaildator()
    }

    @Test
    fun checkPasswordIsVaild() {
        val result = passwordVaildator.checkPasswordIsVaild("123456")
        assertEquals(true, result)
    }

    @Test
    fun passwordlengthShouldBeLessThenFithteen() {
        val result = passwordVaildator.checkPasswordIsVaild("12345678910111213141516")
        assertEquals(false, result)
    }


}