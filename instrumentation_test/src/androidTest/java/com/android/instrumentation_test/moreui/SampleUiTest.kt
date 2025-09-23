package com.android.instrumentation_test.moreui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.android.instrumentation_test.R
import org.junit.Rule
import org.junit.Test

class SampleUiTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(SampleUi::class.java)

    @Test
    fun testSubmitButton_expectedCorrectNote() {
        onView(withId(R.id.note)).perform(typeText("Hello"))
        onView(withId(R.id.note_description)).perform(typeText("HI there"), closeSoftKeyboard())

        onView(withId(R.id.submit_button)).perform(click())
        onView(withId(R.id.text_msg)).check(matches(withText("Note: Hello HI there")))
    }
}