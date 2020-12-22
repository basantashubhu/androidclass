package com.example.androidclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class RegistrationActivity : AppCompatActivity() {
    private lateinit var departmentSpinner : Spinner
    private lateinit var batchSpinner : Spinner
    private lateinit var studentRadio : RadioButton
    private lateinit var staffRadio : RadioButton
    private lateinit var studentStaffText : TextView
    private lateinit var registrationButton : Button

    private lateinit var fullName : EditText
    private lateinit var emailAddress : EditText
    private lateinit var password : EditText
    private lateinit var confirmPassword : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        departmentSpinner = findViewById(R.id.department_spinner)
        batchSpinner = findViewById(R.id.batch_spinner)
        studentRadio = findViewById(R.id.student_radio)
        staffRadio = findViewById(R.id.staff_radio)
        studentStaffText = findViewById(R.id.student_staff_tv)
        registrationButton = findViewById(R.id.register_btn)

        // from
        fullName = findViewById(R.id.full_name_et)
        emailAddress = findViewById(R.id.email_address_et)
        password = findViewById(R.id.password_et)
        confirmPassword = findViewById(R.id.confirm_password_et)

        loadSpinner()
        loadRadioEvent()
        attachEventLister()
    }

    private fun loadSpinner() {
        departmentSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayOf(
                "Academic", "Program Office", "Management", "Reception"
            )
        )

        batchSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayOf(
                "25A", "25B", "25C", "25D"
            )
        )
    }

    private fun loadRadioEvent() {
        staffRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                studentStaffText.text = "Department"
                batchSpinner.visibility = View.GONE
                departmentSpinner.visibility = View.VISIBLE
            } else {
                studentStaffText.text = "Batch"
                departmentSpinner.visibility = View.GONE
                batchSpinner.visibility = View.VISIBLE
            }
        }
    }

    private fun attachEventLister() {
        registrationButton.setOnClickListener {
            val profileActivity = Intent(this, ProfileActivity::class.java)
            profileActivity.putExtra("full_name", fullName.text.toString())
            profileActivity.putExtra("email_address", emailAddress.text.toString())
            profileActivity.putExtra("is_student", studentRadio.isChecked.toString())
            profileActivity.putExtra("is_staff", staffRadio.isChecked.toString())
            profileActivity.putExtra("batch", batchSpinner.selectedItem.toString())
            profileActivity.putExtra("department", departmentSpinner.selectedItem.toString())
            profileActivity.putExtra("password", password.text.toString())
            profileActivity.putExtra("confirm_password", confirmPassword.text.toString())
            startActivity(profileActivity)
        }
    }
}