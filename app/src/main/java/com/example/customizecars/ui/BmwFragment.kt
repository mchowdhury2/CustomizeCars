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

class BmwFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvalue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_bmw, container, false)
        v.setOnClickListener(this)

        val radiobuttonx = v.findViewById<RadioButton>(R.id.radioButtonx)
        radiobuttonx.setOnClickListener(this)

        val radiobuttonm = v.findViewById<RadioButton>(R.id.radioButtonm)
        radiobuttonm.setOnClickListener(this)

        val radiobutton740 = v.findViewById<RadioButton>(R.id.radioButton740)
        radiobutton740.setOnClickListener(this)

        val radiobuttoni = v.findViewById<RadioButton>(R.id.radioButtoni)
        radiobuttoni.setOnClickListener(this)

        val radiobutton430 = v.findViewById<RadioButton>(R.id.radioButton430)
        radiobutton430.setOnClickListener(this)

        val radiobutton440 = v.findViewById<RadioButton>(R.id.radioButton440)
        radiobutton440.setOnClickListener(this)

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
                    R.id.radioButtonx ->
                        if (checked) {
                            radiobuttonvalue = "x"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonm ->
                        if (checked) {
                            radiobuttonvalue = "m"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButton740 ->
                        if (checked) {
                            radiobuttonvalue = "740"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtoni ->
                        if (checked) {
                            radiobuttonvalue = "i"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButton430 ->
                        if (checked) {
                            radiobuttonvalue = "430"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButton440 ->
                        if (checked) {
                            radiobuttonvalue = "440"
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

