package com.android.unittestinandroid

import org.junit.Before
import org.junit.Test

class StringVaildatorTest {

    lateinit var stringVaildator: StringVaildator

    @Before
    fun setUp(){
        stringVaildator = StringVaildator()
    }

    @Test
    fun checkStringIsPalindrome(){
        val result = stringVaildator.isPalindrome("madam")
        assert(result)

    }

    @Test
    fun checkStringIsNotPalindrome(){
        val result = stringVaildator.isPalindrome("hello")
        assert(!result)
    }
}