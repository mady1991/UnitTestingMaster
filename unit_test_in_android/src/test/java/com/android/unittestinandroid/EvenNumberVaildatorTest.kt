package com.android.unittestinandroid

import org.junit.Before
import org.junit.Test

class EvenNumberVaildatorTest {

    lateinit var evenNumberVaildator: EvenNumberVaildator;

    @Before
    fun setUp(){
        evenNumberVaildator = EvenNumberVaildator()
    }

    @Test
    fun checkNumberIsEven(){
        val result = evenNumberVaildator.vaildate(2)
        assert(result)
    }

    @Test
    fun checkNumberIsNotEven(){
        val result = evenNumberVaildator.vaildate(3)
        assert(!result)
    }

}