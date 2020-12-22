package com.example.androidclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class CapitalActivity : AppCompatActivity() {
    private lateinit var capitalTv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capital)

        capitalTv = findViewById(R.id.capital_tv)

        val country = intent.getStringExtra("country")
        val capital = intent.getStringExtra("capital")
        capitalTv.text = "$country's capital is $capital"
    }
}