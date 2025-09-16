package com.android.instrumentation_test.non_ui

import android.content.Context
import com.google.gson.Gson

class QuotesManager {
    var qoutesList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun poppulatetQuotesListFromAssest(context: Context, fileName: String) {

        val inputStream = context.assets.open(fileName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        qoutesList = gson.fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuoteList(quotesList: Array<Quote>) {
        qoutesList = quotesList
    }

    fun getCurrentQuote(): Quote {
        return qoutesList[currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == qoutesList.size - 1) {
            return qoutesList[currentQuoteIndex]
        }
        return qoutesList[++currentQuoteIndex]
    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) {
            return qoutesList[currentQuoteIndex]
        }
        return qoutesList[--currentQuoteIndex]
    }

}