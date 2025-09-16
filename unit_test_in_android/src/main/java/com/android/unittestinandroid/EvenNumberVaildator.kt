package com.android.unittestinandroid

class EvenNumberVaildator {

    fun vaildate(number: Int): Boolean {
        return if (number % 2 == 0) true else false
    }
}