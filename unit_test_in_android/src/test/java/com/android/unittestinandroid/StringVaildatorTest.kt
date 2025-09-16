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

    @Test
    fun checkStringIsEmpty(){
        val result = stringVaildator.isPalindrome("")
        assert(result)
    }

    @Test
    fun checkHelloWorldIsNotDuplicateString(){
        val result = stringVaildator.stringDuplicate("hello world")
        assert(!result)
    }

    @Test
    fun checkRamRamDuplicateString(){
        val result = stringVaildator.stringDuplicate("ram ram")
        assert(result)
    }
}