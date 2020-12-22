package com.example.androidclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var listViewBtn : Button
    private lateinit var countryListBtn : Button
    private lateinit var registrationBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewBtn = findViewById(R.id.list_view_btn)
        countryListBtn = findViewById(R.id.county_list_button)
        registrationBtn = findViewById(R.id.registration_btn)

        initLister()
    }

    private fun initLister() {
        listViewBtn.setOnClickListener(Dashboard(this))
        countryListBtn.setOnClickListener(Dashboard(this))
        registrationBtn.setOnClickListener(Dashboard(this))
    }
}