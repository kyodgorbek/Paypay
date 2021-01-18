package com.example.myapplication

data class CurrencyResponse(
    val privacy: String,
    val quotes: Quotes,
    val source: String,
    val success: Boolean,
    val terms: String,
    val timestamp: Int
)