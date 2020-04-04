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

class FordFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvalue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_ford, container, false)
        v.setOnClickListener(this)

        val radiobuttonfiesta = v.findViewById<RadioButton>(R.id.radioButtonfiesta)
        radiobuttonfiesta.setOnClickListener(this)

        val radiobuttonfusion = v.findViewById<RadioButton>(R.id.radioButtonfusion)
        radiobuttonfusion.setOnClickListener(this)

        val radiobuttonmustang = v.findViewById<RadioButton>(R.id.radioButtonmustang)
        radiobuttonmustang.setOnClickListener(this)

        val radiobuttonshelby = v.findViewById<RadioButton>(R.id.radioButtonshelby)
        radiobuttonshelby.setOnClickListener(this)

        val radiobuttonedge = v.findViewById<RadioButton>(R.id.radioButtonedge)
        radiobuttonedge.setOnClickListener(this)

        val radiobuttonescape = v.findViewById<RadioButton>(R.id.radioButtonescape)
        radiobuttonescape.setOnClickListener(this)

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
                    R.id.radioButtonfiesta ->
                        if (checked) {
                            radiobuttonvalue = "fiesta"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonfusion ->
                        if (checked) {
                            radiobuttonvalue = "fusion"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonmustang ->
                        if (checked) {
                            radiobuttonvalue = "mustang"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonshelby ->
                        if (checked) {
                            radiobuttonvalue = "shelby"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonedge ->
                        if (checked) {
                            radiobuttonvalue = "edge"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonescape ->
                        if (checked) {
                            radiobuttonvalue = "escape"
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

