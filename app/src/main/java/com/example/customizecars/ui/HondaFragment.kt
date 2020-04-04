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

class HondaFragment: Fragment(), View.OnClickListener {
    lateinit var radiobuttonvalue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_honda, container, false)
        v.setOnClickListener(this)


        val radiobuttonaccord = v.findViewById<RadioButton>(R.id.radioButtonaccord)
        radiobuttonaccord.setOnClickListener(this)

        val radiobuttoncivic = v.findViewById<RadioButton>(R.id.radioButtoncivic)
        radiobuttoncivic.setOnClickListener(this)

        val radiobuttoncrv = v.findViewById<RadioButton>(R.id.radioButtoncrv)
        radiobuttoncrv.setOnClickListener(this)

        val radiobuttonhrv = v.findViewById<RadioButton>(R.id.radioButtonhrv)
        radiobuttonhrv.setOnClickListener(this)

        val radiobuttonodyssey = v.findViewById<RadioButton>(R.id.radioButtonodyssey)
        radiobuttonodyssey.setOnClickListener(this)

        val radiobuttonpilot = v.findViewById<RadioButton>(R.id.radioButtonpilot)
        radiobuttonpilot.setOnClickListener(this)

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
                    R.id.radioButtonaccord ->
                        if (checked) {
                            radiobuttonvalue = "accord"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtoncivic ->
                        if (checked) {
                            radiobuttonvalue = "civic"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtoncrv ->
                        if (checked) {
                            radiobuttonvalue = "crv"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonhrv ->
                        if (checked) {
                            radiobuttonvalue = "hrv"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonodyssey ->
                        if (checked) {
                            radiobuttonvalue = "odyssey"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonpilot ->
                        if (checked) {
                            radiobuttonvalue = "pilot"
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

