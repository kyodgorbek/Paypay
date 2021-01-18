package com.example.myapplication.internet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyClient {


    private val BASE_URL = "http://api.currencylayer.com/"
    public var retrofit: Retrofit? = null

    public fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}

