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



class AcuraFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvalue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_acura, container, false)
        v.setOnClickListener(this)

        val radiobuttonilx = v.findViewById<RadioButton>(R.id.radioButtonilx)
        radiobuttonilx.setOnClickListener(this)

        val radiobuttontlx = v.findViewById<RadioButton>(R.id.radioButtontlx)
        radiobuttontlx.setOnClickListener(this)

        val radiobuttonmdx = v.findViewById<RadioButton>(R.id.radioButtonmdx)
        radiobuttonmdx.setOnClickListener(this)

        val radiobuttonnsx = v.findViewById<RadioButton>(R.id.radioButtonnsx)
        radiobuttonnsx.setOnClickListener(this)

        val radiobuttonrdx = v.findViewById<RadioButton>(R.id.radioButtonrdx)
        radiobuttonrdx.setOnClickListener(this)

        val radiobuttonrlx = v.findViewById<RadioButton>(R.id.radioButtonrlx)
        radiobuttonrlx.setOnClickListener(this)

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
                        R.id.radioButtonilx ->
                            if (checked) {
                                radiobuttonvalue = "ILX"
                                Log.d("Creating", radiobuttonvalue)
                            }
                        R.id.radioButtontlx ->
                            if (checked) {
                                radiobuttonvalue = "TLX"
                                Log.d("Creating", radiobuttonvalue)
                            }
                        R.id.radioButtonmdx ->
                            if (checked) {
                                radiobuttonvalue = "MDX"
                                Log.d("Creating", "I am at the mdx button.")
                            }
                        R.id.radioButtonnsx ->
                            if (checked) {
                                radiobuttonvalue = "NSX"
                                Log.d("Creating", "I am at the nsx button.")
                            }
                        R.id.radioButtonrdx ->
                            if (checked) {
                                radiobuttonvalue = "RDX"
                                Log.d("Creating", "I am at the rdx button.")
                            }
                        R.id.radioButtonrlx ->
                            if (checked) {
                                radiobuttonvalue = "RLX"
                                Log.d("Creating", "I am at the rlx button.")
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