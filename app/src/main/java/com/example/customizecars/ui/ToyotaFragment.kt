package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.customizecars.R

class ToyotaFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvalue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_toyota, container, false)
        v.setOnClickListener(this)

        val radiobuttoncamry = v.findViewById<RadioButton>(R.id.radioButtoncamry)
        radiobuttoncamry.setOnClickListener(this)

        val radiobuttoncorolla = v.findViewById<RadioButton>(R.id.radioButtoncorolla)
        radiobuttoncorolla.setOnClickListener(this)

        val radiobuttonprius = v.findViewById<RadioButton>(R.id.radioButtonprius)
        radiobuttonprius.setOnClickListener(this)

        val radiobuttonrav4 = v.findViewById<RadioButton>(R.id.radioButtonrav4)
        radiobuttonrav4.setOnClickListener(this)

        val radiobuttonsienna = v.findViewById<RadioButton>(R.id.radioButtonsienna)
        radiobuttonsienna.setOnClickListener(this)

        val radiobutton4runner = v.findViewById<RadioButton>(R.id.radioButton4runner)
        radiobutton4runner.setOnClickListener(this)

        val buttoninternal = v.findViewById<Button>(R.id.buttoninternal)
        buttoninternal.setOnClickListener(this)

        val buttonexternal = v.findViewById<Button>(R.id.buttonexternal)
        buttonexternal.setOnClickListener(this)

        val buttonlocation = v.findViewById<Button>(R.id.buttonlocation)
        buttonlocation.setOnClickListener(this)

        val buttonreview = v.findViewById<Button>(R.id.buttonreview)
        buttonreview.setOnClickListener(this)

        return v
    }









    override fun onClick(view: View) {

        val activity = activity
        var checked: Boolean


        if (activity != null) {
            if (view is RadioButton) {
                checked = view.isChecked
                when (view.getId()) {
                    R.id.radioButtoncamry ->
                        if (checked) {
                            radiobuttonvalue = "camry"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtoncorolla ->
                        if (checked) {
                            radiobuttonvalue = "corolla"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonprius ->
                        if (checked) {
                            radiobuttonvalue = "prius"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonrav4 ->
                        if (checked) {
                            radiobuttonvalue = "rav4"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonsienna ->
                        if (checked) {
                            radiobuttonvalue = "sienna"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButton4runner ->
                        if (checked) {
                            radiobuttonvalue = "4runner"
                            Log.d("Creating", radiobuttonvalue)
                        }

                }
            }
            when (view.getId()) {
                R.id.buttoninternal -> {
                    startActivity(
                        Intent(
                            activity.applicationContext,
                            InternalActivity::class.java
                        )
                    )
                }
                R.id.buttonexternal -> {
                    startActivity(
                        Intent(
                            activity.applicationContext,
                            ExternalActivity::class.java
                        )
                    )
                }

                R.id.buttonlocation -> {
                    startActivity(
                        Intent(
                            activity.applicationContext,
                            LocationActivity::class.java
                        )
                    )
                }

                R.id.buttonreview -> {
                    startActivity(
                        Intent(
                            activity.applicationContext,
                            ReviewActivity::class.java
                        )
                    )
                }
            }
        }
    }
}

