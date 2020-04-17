package com.example.customizecars.ui

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import kotlinx.android.synthetic.main.activity_external.*
import kotlinx.android.synthetic.main.activity_internal.*

class InternalFragment: Fragment(), View.OnClickListener {

    var radiobuttonvaluecolor = "null"
    var radiobuttonvaluescreen = "null"
    var radiobuttonvaluesunroof = "null"
    var radiobuttonvaluegps = "null"
    lateinit var errorinternal: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_internal, container, false)
        v.setOnClickListener(this)

        errorinternal = v.findViewById(R.id.errorinernal)

        val radiobuttonintwhite = v.findViewById<RadioButton>(R.id.radioButtonintwhite)
        radiobuttonintwhite.setOnClickListener(this)

        val radiobuttonintblack = v.findViewById<RadioButton>(R.id.radioButtonintblack)
        radiobuttonintblack.setOnClickListener(this)

        val radiobuttonintgray = v.findViewById<RadioButton>(R.id.radioButtonintgray)
        radiobuttonintgray.setOnClickListener(this)

        val radiobuttonintblue = v.findViewById<RadioButton>(R.id.radioButtonintblue)
        radiobuttonintblue.setOnClickListener(this)

        val radiobuttonint4_0 = v.findViewById<RadioButton>(R.id.radioButtonint4_5)
        radiobuttonint4_0.setOnClickListener(this)

        val radiobuttonint5_0 = v.findViewById<RadioButton>(R.id.radioButtonint5_0)
        radiobuttonint5_0.setOnClickListener(this)

        val radiobuttonint5_5 = v.findViewById<RadioButton>(R.id.radioButtonint5_5)
        radiobuttonint5_5.setOnClickListener(this)

        val radiobuttonint6_0 = v.findViewById<RadioButton>(R.id.radioButtonint6_0)
        radiobuttonint6_0.setOnClickListener(this)

        val radiobuttonsunyes = v.findViewById<RadioButton>(R.id.radioButtonsunyes)
        radiobuttonsunyes.setOnClickListener(this)

        val radiobuttonsunno = v.findViewById<RadioButton>(R.id.radioButtonsunno)
        radiobuttonsunno.setOnClickListener(this)

        val radiobuttongpsyes = v.findViewById<RadioButton>(R.id.radioButtongpsyes)
        radiobuttongpsyes.setOnClickListener(this)

        val radiobuttongpsno = v.findViewById<RadioButton>(R.id.radioButtongpsno)
        radiobuttongpsno.setOnClickListener(this)

        val buttoninternalDone = v.findViewById<Button>(R.id.buttoninternaldone)
        buttoninternalDone.setOnClickListener(this)

        return v
    }

        fun finish() {
                val data = Intent()
                data.putExtra("valuecolor", radiobuttonvaluecolor)
                data.putExtra("valuescreen", radiobuttonvaluescreen)
                data.putExtra("valuesunroof", radiobuttonvaluesunroof)
                data.putExtra("valuegps", radiobuttonvaluegps)
                activity?.setResult(RESULT_OK, data)
                activity?.finish()
        }








    override fun onClick(view: View) {
        val activity = activity
        var checked = false


        if (activity != null){
            if (view is RadioButton){
                checked = view.isChecked

                when (view.getId()){
                    R.id.radioButtonintwhite ->
                        if (checked){
                            radiobuttonvaluecolor = "White"
                            Log.d("Creating", radiobuttonvaluecolor)
                        }
                    R.id.radioButtonintblack ->
                        if (checked){
                            radiobuttonvaluecolor = "Black"
                            Log.d("Creating", radiobuttonvaluecolor)
                        }
                    R.id.radioButtonintgray ->
                        if (checked){
                            radiobuttonvaluecolor = "Gray"
                            Log.d("Creating", radiobuttonvaluecolor)
                        }
                    R.id.radioButtonintblue ->
                        if (checked){
                            radiobuttonvaluecolor = "Blue"
                            Log.d("Creating", radiobuttonvaluecolor)
                        }
                    R.id.radioButtonint4_5 ->
                        if (checked){
                            radiobuttonvaluescreen = "4.5\""
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonint5_0 ->
                        if (checked){
                            radiobuttonvaluescreen = "5.0\""
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonint5_5 ->
                        if (checked){
                            radiobuttonvaluescreen = "5.5\""
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonint6_0 ->
                        if (checked){
                            radiobuttonvaluescreen = "6.0\""
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonsunyes ->
                        if (checked){
                            radiobuttonvaluesunroof = "Yes"
                            Log.d("Creating", radiobuttonvaluesunroof)
                        }
                    R.id.radioButtonsunno ->
                        if (checked){
                            radiobuttonvaluesunroof = "No"
                            Log.d("Creating", radiobuttonvaluesunroof)
                        }
                    R.id.radioButtongpsyes ->
                        if (checked){
                            radiobuttonvaluegps = "Yes"
                            Log.d("Creating", radiobuttonvaluegps)
                        }
                    R.id.radioButtongpsno ->
                        if (checked){
                            radiobuttonvaluegps = "No"
                            Log.d("Creating", radiobuttonvaluegps)
                        }
                }
            }
            when (view.getId()){

                R.id.buttoninternaldone ->

                    if (radiobuttonvaluecolor != "null" && radiobuttonvaluegps != "null" && radiobuttonvaluescreen != "null" && radiobuttonvaluesunroof != "null") {
                        finish()
                    }
                    else {
                        errorinternal.setText("Error: You have not selected one of the options.")
                    }

            }
        }
    }
}