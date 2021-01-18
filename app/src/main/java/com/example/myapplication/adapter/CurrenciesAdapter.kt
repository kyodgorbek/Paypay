package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CurrencyResponse
import com.example.myapplication.Quotes
import com.example.myapplication.R

class CurrenciesAdapter(private val context: Context) : RecyclerView.Adapter<CurrenciesAdapter.MyViewHolder>() {

    var list: List<Pair<String, Double>> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.currency_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list.get(position)
        holder.name.text = user.first
        holder.info1.text = user.second.toString()
//        holder.info2.text = user?.quotes.USDAED.toString()
//        val addressObj = user.quotes.USDAOA.toString()
//        holder.address.text = user.quotes.USDAFN.toString()
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.txt_user_name)
        val info1: TextView = view.findViewById(R.id.txt_user_info1)
        val info2: TextView = view.findViewById(R.id.txt_user_info2)
        val address: TextView = view.findViewById(R.id.txt_user_address)

    }

}
