package com.example.androidclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {
    private lateinit var fullNameText : TextView
    private lateinit var emailAddressText : TextView
    private lateinit var departmentBatchText : TextView
    private lateinit var sectionText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        fullNameText = findViewById(R.id.full_name_tv)
        emailAddressText = findViewById(R.id.email_address_tv)
        departmentBatchText = findViewById(R.id.department_batch_tv)
        sectionText = findViewById(R.id.section_tv)

        loadData()
    }

    private fun loadData() {
        fullNameText.text = intent.getStringExtra("full_name")
        emailAddressText.text = intent.getStringExtra("email_address")
        if (intent.getStringExtra("is_student") == "true") {
            departmentBatchText.text = "Batch :"
            sectionText.text = intent.getStringExtra("batch")
        } else if(intent.getStringExtra("is_staff") == "true") {
            departmentBatchText.text = "Department :"
            sectionText.text = intent.getStringExtra("department")
        }
    }
}