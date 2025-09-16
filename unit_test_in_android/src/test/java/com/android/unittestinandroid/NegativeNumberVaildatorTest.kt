package com.android.unittestinandroid

import org.junit.Before
import org.junit.Test


class NegativeNumberVaildatorTest {

    lateinit var negativeNumberVaildator: NegativeNumberVaildator;

    @Before
    fun setUp() {
        negativeNumberVaildator = NegativeNumberVaildator()
    }

    //This Test case will fail as we are just checking weather is number is negative or not.
    @Test
    fun checkNumberIsNegative() {
        val result = negativeNumberVaildator.vaildate(-1)
        assert(!result)
    }

    @Test
    fun checkNumberIsNotNegative() {
        val result = negativeNumberVaildator.vaildate(1)
        assert(result)
    }

}