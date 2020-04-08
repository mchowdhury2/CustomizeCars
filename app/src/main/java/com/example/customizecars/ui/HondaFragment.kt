package com.example.customizecars.ui

import android.app.Activity
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
    lateinit var selectedyear: String
    var valueinterior =  ArrayList<String>()
    var valueexterior = ArrayList<String>()
    lateinit var valueselectedlocation: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_honda, container, false)
        v.setOnClickListener(this)

        selectedyear = getActivity()!!.getIntent().getStringExtra("selectedyear")

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
                            radiobuttonvalue = "Accord"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtoncivic ->
                        if (checked) {
                            radiobuttonvalue = "Civic"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtoncrv ->
                        if (checked) {
                            radiobuttonvalue = "CRV"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonhrv ->
                        if (checked) {
                            radiobuttonvalue = "HRV"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonodyssey ->
                        if (checked) {
                            radiobuttonvalue = "Odyssey"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonpilot ->
                        if (checked) {
                            radiobuttonvalue = "Pilot"
                            Log.d("Creating", radiobuttonvalue)
                        }

                }
            }
            when (view.getId()) {
                R.id.buttoninternal -> {
                    val intent = (
                            Intent(
                                activity.applicationContext,
                                InternalActivity::class.java
                            )
                            )
                    startActivityForResult(intent, 1)
                }
                R.id.buttonexternal -> {
                    val intent = (
                            Intent(
                                activity.applicationContext,
                                ExternalActivity::class.java
                            )
                            )
                    startActivityForResult(intent, 2)
                }

                R.id.buttonlocation -> {
                    val intent = (
                            Intent(
                                activity.applicationContext,
                                LocationActivity::class.java
                            )
                            )
                    startActivityForResult(intent, 3)
                }

                R.id.buttonreview -> {
                    val intent = (
                            Intent(
                                activity.applicationContext,
                                ReviewActivity::class.java
                            )
                            )
                    intent.putExtra("selectedyear", selectedyear)
                    intent.putExtra("selectedmake", "Hunda")
                    intent.putExtra("selectedmodel", radiobuttonvalue)
                    intent.putExtra("valueinterior", valueinterior)
                    intent.putExtra("valueexterior", valueexterior)
                    intent.putExtra("valueselectedlocation", valueselectedlocation)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val valuecolor = data?.extras?.get("valuecolor").toString()
            Log.d("Creating", valuecolor)
            val valuescreen = data?.extras?.get("valuescreen").toString()
            Log.d("Creating", valuescreen)
            val valuesunroof = data?.extras?.get("valuesunroof").toString()
            Log.d("Creating", valuesunroof)
            val valuegps = data?.extras?.get("valuegps").toString()
            Log.d("Creating", valuegps)
            valueinterior.add(valuecolor)
            Log.d("array", valueinterior.get(0))
            valueinterior.add(valuescreen)
            valueinterior.add(valuesunroof)
            valueinterior.add(valuegps)
        }

        if (requestCode == 2 && resultCode == Activity.RESULT_OK){
            val valuewheel = data?.extras?.get("valuewheel").toString()
            Log.d("Creating", valuewheel)
            val valuebumper = data?.extras?.get("valuebumper").toString()
            Log.d("Creating", valuebumper)
            val valueengine = data?.extras?.get("valueengine").toString()
            Log.d("Creating", valueengine)
            valueexterior.add(valuewheel)
            valueexterior.add(valuebumper)
            valueexterior.add(valueengine)
        }

        if (requestCode == 3 && resultCode == Activity.RESULT_OK){
            val valuelocation = data?.extras?.get("valuelocation").toString()
            Log.d("Creating", valuelocation)
            valueselectedlocation = valuelocation
        }
    }
}

