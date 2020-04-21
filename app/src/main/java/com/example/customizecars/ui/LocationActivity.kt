package com.example.customizecars.ui

import android.content.Intent
import android.location.Location
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


class LocationActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return LocationFragment()
    }

    fun showMap(view: View){

        val intent = Intent(this, MapsActivity::class.java).apply {
        }
        Toast.makeText(applicationContext, "show map", Toast.LENGTH_LONG).show()
        startActivity(intent)
    }


}
