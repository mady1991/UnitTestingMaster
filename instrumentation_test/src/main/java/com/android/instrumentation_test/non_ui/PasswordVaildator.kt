package com.android.instrumentation_test.non_ui

class PasswordVaildator {

    fun checkPasswordIsVaild(password: String): Boolean {
        if (password == null || password != null && password.isEmpty()) {
            return false
        } else if (password.length > 6 && password.length < 15) {
            return true
        } else {
            return false
        }
    }
}