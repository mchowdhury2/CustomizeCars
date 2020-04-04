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

class LocationFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvaluelocation: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_location, container, false)
        v.setOnClickListener(this)

        val radiobuttongford = v.findViewById<RadioButton>(R.id.radioButtongford)
        radiobuttongford.setOnClickListener(this)

        val radiobuttontwest = v.findViewById<RadioButton>(R.id.radioButtontwest)
        radiobuttontwest.setOnClickListener(this)

        val radiobuttonrhonda = v.findViewById<RadioButton>(R.id.radioButtonrhonda)
        radiobuttonrhonda.setOnClickListener(this)

        val radiobuttonlacura = v.findViewById<RadioButton>(R.id.radioButtonlacura)
        radiobuttonlacura.setOnClickListener(this)

        val radiobuttonkbmw = v.findViewById<RadioButton>(R.id.radioButtonkbmw)
        radiobuttonkbmw.setOnClickListener(this)

        val radiobuttonginf = v.findViewById<RadioButton>(R.id.radioButtonginf)
        radiobuttonginf.setOnClickListener(this)

        val buttonlocationdone = v.findViewById<Button>(R.id.buttonlocationdone)
        buttonlocationdone.setOnClickListener(this)

        return v
    }









    override fun onClick(view: View) {
        val activity = activity
        var checked: Boolean

        if (activity != null){
            if (view is RadioButton){
                checked = view.isChecked

                when (view.getId()){
                    R.id.radioButtongford ->
                        if (checked) {
                            radiobuttonvaluelocation = "gford"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtontwest ->
                        if (checked) {
                            radiobuttonvaluelocation = "twest"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonrhonda ->
                        if (checked) {
                            radiobuttonvaluelocation = "rhonda"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonlacura ->
                        if (checked) {
                            radiobuttonvaluelocation = "lacura"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonkbmw ->
                        if (checked) {
                            radiobuttonvaluelocation = "kbmw"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonginf ->
                        if (checked) {
                            radiobuttonvaluelocation = "ginf"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                }
            }
            when (view.getId()){
                R.id.buttonlocationdone ->
                    activity.finish()
            }
        }
    }
}