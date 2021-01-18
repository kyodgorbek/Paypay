package com.example.myapplication.internet

import com.example.myapplication.CurrencyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CurrenciesResponse {

    @GET("live?access_key=1f72464a836ff6084b8b1780e3feadf9")
    fun getCurrencies(): Call<List<CurrencyResponse>>

}