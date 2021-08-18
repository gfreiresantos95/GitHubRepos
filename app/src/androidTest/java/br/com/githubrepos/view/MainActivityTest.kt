package br.com.githubrepos.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import br.com.githubrepos.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isLoadingVisibleOnAppLaunch() {
        onView(withId(R.id.loading_progress)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isListVisibleOnRecycler() {
        
    }
}