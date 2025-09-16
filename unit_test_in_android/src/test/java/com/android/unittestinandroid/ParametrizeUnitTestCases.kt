package com.android.unittestinandroid

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParametrizeUnitTestCases(val input: String, val expectedResult: Boolean) {

    @Test
    fun checkStringIsPalindromeParameterized() {
        val stringVaildator = StringVaildator()
        val result = stringVaildator.isPalindrome(input)
        assert(result == expectedResult)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: checkPalindrome({0})={1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("madam", true),
                arrayOf("hello", false),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}