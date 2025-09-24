package com.android.coroutines_unit_testing

import kotlinx.coroutines.*

class Utils(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String {
        delay(1000)
        return "mady1991"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "User - mady1991"
    }

    suspend fun getAddress(): String {
        withContext(dispatcher) {
            delay(5000)
        }
        return "World"
    }

    var globaArgs = false
    suspend fun getAddressDetail() {
        withContext(dispatcher) {
            globaArgs = true
        }

    }
}