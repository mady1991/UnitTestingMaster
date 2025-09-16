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

    fun reverseString(inputString: String): String {
        if (inputString.isEmpty() || inputString.length == 1) {
            return inputString
        } else {
            return reverseString(inputString.substring(1)) + inputString[0]
        }
    }

    fun stringDuplicate(inputString: String): Boolean {
        if (inputString.isEmpty() || inputString.length == 1) {
            return true
        } else {
            val words = inputString.split("\\s+".toRegex())
            val seen = mutableSetOf<String>()
            for (word in words) {
                if (!seen.add(word)) {
                    return true // duplicate found
                }
            }
            return false

        }
    }


}