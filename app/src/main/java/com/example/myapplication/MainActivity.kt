package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Utility.hideProgressBar
import com.example.myapplication.internet.*
import com.example.myapplication.Utility.isInternetAvailable
import com.example.myapplication.Utility.showProgressBar
import com.example.myapplication.adapter.CurrenciesAdapter
import com.example.myapplication.internet.CurrenciesResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    private var adapter: CurrenciesAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = CurrenciesAdapter(this)

        recycler_main.adapter = adapter

        if (isInternetAvailable()) {
            getUsersData()
        }
    }


    private fun getUsersData() {

        showProgressBar()

        var apiInterface: CurrenciesResponse = CurrencyClient().getApiClient()!!.create(
                CurrenciesResponse::class.java
        )

        apiInterface.getCurrencies().enqueue(object : Callback <List<CurrencyResponse>> {
            override fun onResponse(
                    call: Call <List<CurrencyResponse>>,
                    response: Response <List<CurrencyResponse>>)

             {
            hideProgressBar()
            val currencyResponse = response.body()
            adapter?.list = currencyResponse!!
        }

            override fun onFailure(call: Call<List<CurrencyResponse>>, t: Throwable) {
            hideProgressBar()
            Log.e("error", t.localizedMessage)
        }
        })
    }
}


