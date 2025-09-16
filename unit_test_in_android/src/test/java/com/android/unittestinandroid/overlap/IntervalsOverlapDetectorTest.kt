package com.android.unittestinandroid.overlap

import org.junit.Before
import org.junit.Test


class IntervalsOverlapDetectorTest {
    lateinit var intervalsOverlapDetector: IntervalsOverlapDetector

    @Before
    fun setUp() {
        intervalsOverlapDetector = IntervalsOverlapDetector()
    }

    @Test
    fun overlappingIntervals() {
        val interval1 = Interval(1, 5)
        val interval2 = Interval(4, 8)
        val result = intervalsOverlapDetector.isOverlap(interval1, interval2)
        assert(result)

    }

}