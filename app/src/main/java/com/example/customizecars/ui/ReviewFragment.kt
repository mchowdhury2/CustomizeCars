package com.example.customizecars.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.customizecars.R

class ReviewFragment: Fragment(), View.OnClickListener {

    lateinit var selectedyear: String
    lateinit var selectedmake: String
    lateinit var selectedmodel: String
    var valueinterior =  ArrayList<String>()
    var valueexterior = ArrayList<String>()
    lateinit var valueselectedlocation: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_review, container, false)
        v.setOnClickListener(this)

        selectedyear = getActivity()!!.getIntent().getStringExtra("selectedyear")
        Log.d("Creating", selectedyear)
        selectedmake = getActivity()!!.getIntent().getStringExtra("selectedmake")
        Log.d("Creating", selectedmake)
        selectedmodel = getActivity()!!.getIntent().getStringExtra("selectedmodel")
        Log.d("Creating", selectedmodel)
        valueinterior = (getActivity()!!.getIntent().getStringArrayListExtra("valueinterior"))
        Log.d("Creating", valueinterior.toString())
        Log.d("Creating", valueinterior[0])

        valueexterior = (getActivity()!!.getIntent().getStringArrayListExtra("valueexterior"))
        Log.d("Creating", valueexterior.toString())
        valueselectedlocation = getActivity()!!.getIntent().getStringExtra("valueselectedlocation")
        Log.d("Creating", valueselectedlocation)

        val textreviewyearresult = v.findViewById<TextView>(R.id.textreviewyearresult)
        textreviewyearresult.setText(selectedyear)

        val textreviewmakeresult = v.findViewById<TextView>(R.id.textreviewmakeresult)
        textreviewmakeresult.setText(selectedmake)

        val textreviewmodelresult = v.findViewById<TextView>(R.id.textreviewmodelresult)
        textreviewmodelresult.setText(selectedmodel)

        val textreviewinteriorresult = v.findViewById<TextView>(R.id.textreviewinteriorresult)
        textreviewinteriorresult.setText("Dashboard Color: " + valueinterior[0] + ", Screen Size: " + valueinterior[1] + ", Sun Roof: " + valueinterior[2] + ", Built_in GPS: " + valueinterior[3] + ".")

        val textreviewexteriorresult = v.findViewById<TextView>(R.id.textreviewexteriorresult)
        textreviewexteriorresult.setText("Wheel Type: " + valueexterior[0] + ", Bumper Type: " + valueexterior[1] + ", Engine Size: " + valueexterior[2] + ".")

        val textreviewlocationresult = v.findViewById<TextView>(R.id.textreviewlocationresult)
        textreviewlocationresult.setText(valueselectedlocation)

        val buttonreviewsub = v.findViewById<Button>(R.id.buttonreviewsub)
        buttonreviewsub.setOnClickListener(this)

        return v
    }









    override fun onClick(view: View) {
        val activity = activity

        if (activity != null){
            when (view.getId()){
                R.id.buttonreviewsub ->
                    activity.finish()
            }
        }
    }
}