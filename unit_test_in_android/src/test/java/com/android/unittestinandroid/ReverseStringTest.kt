package com.android.unittestinandroid

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ReverseStringTest(val input: String, val expectedResult: String) {
    lateinit var stringVaildator: StringVaildator

    @Before
    fun setUp() {
        stringVaildator = StringVaildator()
    }

    @Test
    fun checkStringIsReverse() {
        val result = stringVaildator.reverseString("madam")
        assert(result == "madam")
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "{index}: checkPalindrome({0})={1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("madam", "madam"),
                arrayOf("hello", "olleh"),
                arrayOf("a", "a"),
                arrayOf("", "")
            )
        }
    }
}