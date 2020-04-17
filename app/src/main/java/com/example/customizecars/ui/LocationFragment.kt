package com.example.customizecars.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
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

    fun finish() {
        val data = Intent()
        data.putExtra("valuelocation", radiobuttonvaluelocation)
        activity?.setResult(Activity.RESULT_OK, data)
        activity?.finish()
    }


    fun showMap(radiobuttonvaluelocation: String){

        // Create a Uri from an intent string. Use the result to create an Intent.
        val gmmIntentUri: Uri = Uri.parse("geo:39.9961755,-83.018795?q=" + radiobuttonvaluelocation)

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        // Make the Intent explicit by setting the Google Maps package
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps")

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent)
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
                            radiobuttonvaluelocation = "Germain Ford, 7250 Sawmill Rd, Columbus, OH 43235"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtontwest ->
                        if (checked) {
                            radiobuttonvaluelocation = "Toyota West, 1500 Auto Mall Dr, Columbus, OH 43228"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonrhonda ->
                        if (checked) {
                            radiobuttonvaluelocation = "Roush Honda, 100 W Schrock Rd, Westerville, OH 43081"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonlacura ->
                        if (checked) {
                            radiobuttonvaluelocation = "Lindsay Acura, 5880 Scarborough Blvd, Columbus, OH 43232"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonkbmw ->
                        if (checked) {
                            radiobuttonvaluelocation = "Kelly BMW, 4050 Morse Rd, Columbus, OH 43230"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                    R.id.radioButtonginf ->
                        if (checked) {
                            radiobuttonvaluelocation = "Gemain Infinity, 3833 Morse Rd, Columbus, OH 43219"
                            Log.d("Creating", radiobuttonvaluelocation)
                        }
                }
            }

            when (view.getId()){
                R.id.buttonlocationdone ->
                    showMap(radiobuttonvaluelocation)
            }
        }
    }
}