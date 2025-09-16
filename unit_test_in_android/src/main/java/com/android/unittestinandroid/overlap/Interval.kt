package com.android.unittestinandroid.overlap

class Interval(val start: Int, val end: Int) {
    init {
        require(start < end) { "Invalid interval range" }
    }
}