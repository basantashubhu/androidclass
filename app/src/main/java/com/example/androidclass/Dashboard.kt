package com.example.androidclass

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast

class Dashboard(private val context: Context) : View.OnClickListener {

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.list_view_btn -> startListViewActivity()
            R.id.county_list_button -> startCountyActivity()
            R.id.registration_btn -> startRegistrationActivity()
        }
    }

    private fun startListViewActivity() {
        val listViewActivity = Intent(context, ListViewActivity::class.java)
        context.startActivity(listViewActivity)
    }

    private fun startCountyActivity() {
        val countryActivity = Intent(context, CountryActivity::class.java)
        context.startActivity(countryActivity)
    }

    private fun startRegistrationActivity() {
        val registrationActivity = Intent(context, RegistrationActivity::class.java)
        context.startActivity(registrationActivity)
    }
}