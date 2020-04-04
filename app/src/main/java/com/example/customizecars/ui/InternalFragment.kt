package com.example.customizecars.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.customizecars.R

class InternalFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvaluecolor: String
    lateinit var radiobuttonvaluescreen: String
    lateinit var radiobuttonvaluesunroof: String
    lateinit var radiobuttonvaluegps: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_internal, container, false)
        v.setOnClickListener(this)

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










    override fun onClick(view: View) {
        val activity = activity
        var checked: Boolean

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
                            radiobuttonvaluescreen = "4_5"
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonint5_0 ->
                        if (checked){
                            radiobuttonvaluescreen = "5_0"
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonint5_5 ->
                        if (checked){
                            radiobuttonvaluescreen = "5_5"
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonint6_0 ->
                        if (checked){
                            radiobuttonvaluescreen = "6_0"
                            Log.d("Creating", radiobuttonvaluescreen)
                        }
                    R.id.radioButtonsunyes ->
                        if (checked){
                            radiobuttonvaluesunroof = "sunyes"
                            Log.d("Creating", radiobuttonvaluesunroof)
                        }
                    R.id.radioButtonsunno ->
                        if (checked){
                            radiobuttonvaluesunroof = "sunno"
                            Log.d("Creating", radiobuttonvaluesunroof)
                        }
                    R.id.radioButtongpsyes ->
                        if (checked){
                            radiobuttonvaluegps = "gpsyes"
                            Log.d("Creating", radiobuttonvaluegps)
                        }
                    R.id.radioButtongpsno ->
                        if (checked){
                            radiobuttonvaluegps = "gpsno"
                            Log.d("Creating", radiobuttonvaluegps)
                        }
                }
            }
            when (view.getId()){
                R.id.buttoninternaldone ->
                    activity.finish()
            }
        }
    }
}