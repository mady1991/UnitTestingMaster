package com.android.unittestinandroid

class StringVaildator {

    fun isPalindrome(inputString: String): Boolean {
        var i = 0
        var j = inputString.length - 1
        while (i < j) {
            if (inputString[i] != inputString[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }
}