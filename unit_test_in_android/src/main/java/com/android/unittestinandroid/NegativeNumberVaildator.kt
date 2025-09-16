package com.android.unittestinandroid

class NegativeNumberVaildator {

    fun vaildate(number: Int): Boolean {
        return if (number > 0) true else false
    }
}