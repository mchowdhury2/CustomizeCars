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
import kotlinx.android.synthetic.main.activity_infinity.*

class InfinityFragment: Fragment(), View.OnClickListener {

    var radiobuttonvalue = "null"
    var checkinternal = "null"
    var checkexternal = "null"
    var checklocation = "null"
    lateinit var selectedyear: String
    var valueinterior =  ArrayList<String>()
    var valueexterior = ArrayList<String>()
    lateinit var valueselectedlocation: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_infinity, container, false)
        v.setOnClickListener(this)

        selectedyear = getActivity()!!.getIntent().getStringExtra("selectedyear")

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
                            radiobuttonvalue = "Q50"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonq60 ->
                        if (checked) {
                            radiobuttonvalue = "Q60"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonqx50 ->
                        if (checked) {
                            radiobuttonvalue = "QX50"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonqx60 ->
                        if (checked) {
                            radiobuttonvalue = "QX60"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonq70 ->
                        if (checked) {
                            radiobuttonvalue = "Q70"
                            Log.d("Creating", radiobuttonvalue)
                        }
                    R.id.radioButtonq70l ->
                        if (checked) {
                            radiobuttonvalue = "Q70l"
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
                    if (radiobuttonvalue != "null" && checkinternal != "null" && checkexternal != "null" && checklocation != "null") {
                        intent.putExtra("selectedyear", selectedyear)
                        intent.putExtra("selectedmake", "Infinity")
                        intent.putExtra("selectedmodel", radiobuttonvalue)
                        intent.putExtra("valueinterior", valueinterior)
                        intent.putExtra("valueexterior", valueexterior)
                        intent.putExtra("valueselectedlocation", valueselectedlocation)
                        startActivity(intent)
                    }
                    else {
                        errorinfinity.setText("Error: You must select options from this page, internal page, external page and location page.")
                    }
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            checkinternal = "nonull"
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
            checkexternal = "nonull"
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
            checklocation = "nonull"
            val valuelocation = data?.extras?.get("valuelocation").toString()
            Log.d("Creating", valuelocation)
            valueselectedlocation = valuelocation
        }
    }
}