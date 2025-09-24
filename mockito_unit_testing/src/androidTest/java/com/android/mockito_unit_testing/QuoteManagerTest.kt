package com.android.mockito_unit_testing

import android.content.Context
import android.content.res.AssetManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class QuoteManagerTest {

    @Mock
    lateinit var assetManger : AssetManager

    lateinit var context : Context

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun test() {
        val stream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        /*it will return context.assets*/
        doReturn(assetManger).`when`(context).assets
        Mockito.`when`(assetManger.open(anyString())).thenReturn(stream)

        val SUT = QuoteManager()
        SUT.populateQuoteFromAssets(context, "")
        val currentQuote = SUT.getCurrentQuote()
        assertEquals("Success", currentQuote.text)
    }



}