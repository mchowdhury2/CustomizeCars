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

class ExternalFragment: Fragment(), View.OnClickListener {

    lateinit var radiobuttonvaluewheel: String
    lateinit var radiobuttonvaluebumper: String
    lateinit var radiobuttonvalueengine: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_external, container, false)
        v.setOnClickListener(this)

        val radiobuttonextret = v.findViewById<RadioButton>(R.id.radioButtonextret)
        radiobuttonextret.setOnClickListener(this)

        val radiobuttonextmr143 = v.findViewById<RadioButton>(R.id.radioButtonextmr143)
        radiobuttonextmr143.setOnClickListener(this)

        val radiobuttonextpro = v.findViewById<RadioButton>(R.id.radioButtonextpro)
        radiobuttonextpro.setOnClickListener(this)

        val radiobuttonextxm6 = v.findViewById<RadioButton>(R.id.radioButtonextxm6)
        radiobuttonextxm6.setOnClickListener(this)

        val radiobuttonextstd = v.findViewById<RadioButton>(R.id.radioButtonextstd)
        radiobuttonextstd.setOnClickListener(this)

        val radiobuttonextdeep = v.findViewById<RadioButton>(R.id.radioButtonextdeep)
        radiobuttonextdeep.setOnClickListener(this)

        val radiobuttonexttube = v.findViewById<RadioButton>(R.id.radioButtonexttube)
        radiobuttonexttube.setOnClickListener(this)

        val radiobuttonextstep = v.findViewById<RadioButton>(R.id.radioButtonextstep)
        radiobuttonextstep.setOnClickListener(this)

        val radiobuttonext2v6 = v.findViewById<RadioButton>(R.id.radioButtonext2v6)
        radiobuttonext2v6.setOnClickListener(this)

        val radiobuttonext25v6 = v.findViewById<RadioButton>(R.id.radioButtonext25v6)
        radiobuttonext25v6.setOnClickListener(this)

        val radiobuttonext3v6 = v.findViewById<RadioButton>(R.id.radioButtonext3v6)
        radiobuttonext3v6.setOnClickListener(this)

        val radiobuttonext3v8 = v.findViewById<RadioButton>(R.id.radioButtonext3v8)
        radiobuttonext3v8.setOnClickListener(this)

        val buttonextdone = v.findViewById<Button>(R.id.buttonextdone)
        buttonextdone.setOnClickListener(this)

        return v
    }

    fun finish() {
        val data = Intent()
        data.putExtra("valuewheel", radiobuttonvaluewheel)
        data.putExtra("valuebumper", radiobuttonvaluebumper)
        data.putExtra("valueengine", radiobuttonvalueengine)
        activity?.setResult(Activity.RESULT_OK, data)
        activity?.finish()
    }


    override fun onClick(view: View) {

        val activity = activity
        var checked: Boolean

        if (activity != null){
            if (view is RadioButton){
                checked = view.isChecked

                when (view.getId()){
                    R.id.radioButtonextret ->
                        if (checked){
                            radiobuttonvaluewheel = "Retribution"
                            Log.d("Creating", radiobuttonvaluewheel)
                        }
                    R.id.radioButtonextmr143 ->
                        if (checked){
                            radiobuttonvaluewheel = " MR143 CS6"
                            Log.d("Creating", radiobuttonvaluewheel)
                        }
                    R.id.radioButtonextpro ->
                        if (checked){
                            radiobuttonvaluewheel = "Prophecy"
                            Log.d("Creating", radiobuttonvaluewheel)
                        }
                    R.id.radioButtonextxm6 ->
                        if (checked){
                            radiobuttonvaluewheel = "XM-6"
                            Log.d("Creating", radiobuttonvaluewheel)
                        }
                    R.id.radioButtonextstd ->
                        if (checked){
                            radiobuttonvaluebumper = "Standard"
                            Log.d("Creating", radiobuttonvaluebumper)
                        }
                    R.id.radioButtonextdeep ->
                        if (checked){
                            radiobuttonvaluebumper = "Deep Drop"
                            Log.d("Creating", radiobuttonvaluebumper)
                        }
                    R.id.radioButtonexttube ->
                        if (checked){
                            radiobuttonvaluebumper = "Tube"
                            Log.d("Creating", radiobuttonvaluebumper)
                        }
                    R.id.radioButtonextstep ->
                        if (checked){
                            radiobuttonvaluebumper = "Step"
                            Log.d("Creating", radiobuttonvaluebumper)
                        }
                    R.id.radioButtonext2v6 ->
                        if (checked){
                            radiobuttonvalueengine = "2.0L V6"
                            Log.d("Creating", radiobuttonvalueengine)
                        }
                    R.id.radioButtonext25v6 ->
                        if (checked){
                            radiobuttonvalueengine = "2.5L V6"
                            Log.d("Creating", radiobuttonvalueengine)
                        }
                    R.id.radioButtonext3v6 ->
                        if (checked){
                            radiobuttonvalueengine = "3.0L V6"
                            Log.d("Creating", radiobuttonvalueengine)
                        }
                    R.id.radioButtonext3v8 ->
                        if (checked){
                            radiobuttonvalueengine = "3.0L V8"
                            Log.d("Creating", radiobuttonvalueengine)
                        }
                }
            }
            when (view.getId()){
                R.id.buttonextdone ->
                    finish()
            }
        }
    }
}