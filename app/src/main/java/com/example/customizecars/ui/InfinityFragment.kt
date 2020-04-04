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

class InfinityFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvalue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_infinity, container, false)
        v.setOnClickListener(this)

        val radiobuttonq50 = v.findViewById<RadioButton>(R.id.radioButtonq50)
        radiobuttonq50.setOnClickListener(this)

        val radiobuttonq60 = v.findViewById<RadioButton>(R.id.radioButtonq60)
        radiobuttonq60.setOnClickListener(this)

        val radiobuttonqx50 = v.findViewById<RadioButton>(R.id.radioButtonqx50)
        radiobuttonqx50.setOnClickListener(this)

        val radiobuttonqx60 = v.findViewById<RadioButton>(R.id.radioButtonqx60)
        radiobuttonqx60.setOnClickListener(this)

        val radiobuttonq70 = v.findViewById<RadioButton>(R.id.radioButtonq70)
        radiobuttonq70.setOnClickListener(this)

        val radiobuttonq70l = v.findViewById<RadioButton>(R.id.radioButtonq70l)
        radiobuttonq70l.setOnClickListener(this)

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
                    R.id.radioButtonq50 ->
                        if (checked) {
                            radiobuttonvalue = "q50"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonq60 ->
                        if (checked) {
                            radiobuttonvalue = "q60"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonqx50 ->
                        if (checked) {
                            radiobuttonvalue = "qx50"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonqx60 ->
                        if (checked) {
                            radiobuttonvalue = "qx60"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonq70 ->
                        if (checked) {
                            radiobuttonvalue = "q70"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonq70l ->
                        if (checked) {
                            radiobuttonvalue = "q70l"
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

