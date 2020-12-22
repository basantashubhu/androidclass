package com.example.androidclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    private lateinit var listViewLv: ListView
    private val countries = arrayOf(
        "Nepal", "India", "China", "Bhutan",
        "Nepal", "India", "China", "Bhutan",
        "Nepal", "India", "China", "Bhutan",
        "Nepal", "India", "China", "Bhutan",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listViewLv = findViewById(R.id.list_view_lv)
        listViewInit()
    }

    private fun listViewInit() {
        listViewLv.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        )

        listViewLv.setOnItemClickListener { parent, _, position, _ ->
            val country = parent.getItemAtPosition(position).toString()
            makeToast(country)
        }
    }

    private fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}