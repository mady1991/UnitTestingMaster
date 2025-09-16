package com.android.instrumentation_test.non_ui

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuotesManagerTest {

    lateinit var quotesManager: QuotesManager

    @Before
    fun setUp() {
        quotesManager = QuotesManager()
    }


    @Test(expected = FileNotFoundException::class)
    fun poppulatetQuotesListFromAssestButWithFileNotFoundException() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.poppulatetQuotesListFromAssest(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun poppulatetQuotesListFromAssestButWithMalformedJson() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.poppulatetQuotesListFromAssest(context, "malformed.json")
    }

    @Test
    fun poppulatetQuotesListFromAssest() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.poppulatetQuotesListFromAssest(context, "quotes.json")
        assertEquals(20, quotesManager.qoutesList.size)
    }

    @Test
    fun poppulatetQuotesListFromAssest_Previous_Count() {
        quotesManager.populateQuoteList(
            arrayOf(
                Quote("Azab prem ki gazab khani", "jahagir"),
                Quote("Lagan Movie", "Ashuthosh"),
                Quote("Gajni Moviee", "Aamir khan")
            )
        )
        val quote = quotesManager.getPreviousQuote()
        assertEquals("jahagir", quote.author)
    }

    @Test
    fun poppulatetQuotesListFromAssest_Next_Count() {
        quotesManager.populateQuoteList(
            arrayOf(
                Quote("Azab prem ki gazab khani", "jahagir"),
                Quote("Lagan Movie", "Ashuthosh"),
                Quote("Gajni Moviee", "Aamir khan")
            )
        )
        val quote = quotesManager.getNextQuote()
        assertEquals("Ashuthosh", quote.author)
    }

}