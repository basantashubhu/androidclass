package com.example.androidclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountryActivity : AppCompatActivity() {
    private lateinit var countryListView : ListView
    private val countries = arrayOf(
        "Nepal", "Kathmandu",
        "China", "Beijing",
        "India", "New Delhi",
        "Bhutan", "Dhaka",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        countryListView = findViewById(R.id.county_list_view)
        countryListViewInit()
    }

    private fun countryListViewInit() {
        val countryCapitalMap = mutableMapOf<String, String>()
        for (i in countries.indices step 2) {
            countryCapitalMap[countries[i]] = countries[i+1]
        }

        countryListView.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countryCapitalMap.keys.toTypedArray()
        )

        countryListView.setOnItemClickListener { parent, _, position, _ ->
            val country = parent.getItemAtPosition(position).toString()
            val capital = countryCapitalMap[country]
            val capitalActivityIntent = Intent(this, CapitalActivity::class.java)
            capitalActivityIntent.putExtra("country", country)
            capitalActivityIntent.putExtra("capital", capital)
            startActivity(capitalActivityIntent)
        }
    }

    private fun makeToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}