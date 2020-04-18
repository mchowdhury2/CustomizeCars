package com.example.customizecars.ui

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import kotlinx.android.synthetic.main.activity_location.*

const val SELECTED_LANGUAGE = "language"
const val ENGLISH = "en"
const val SPANISH = "es"
const val GERMAN = "de"

private lateinit var sharedPreferences: SharedPreferences

class LanguageFragment: Fragment(), View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_location, container, false)
        v.setOnClickListener(this)

        val radiobuttonEnglish = v.findViewById<RadioButton>(R.id.radioButtonEnglish)
        radiobuttonEnglish.setOnClickListener(this)

        val radiobuttonSpanish = v.findViewById<RadioButton>(R.id.radioButtonSpanish)
        radiobuttonSpanish.setOnClickListener(this)

        val radiobuttonGerman = v.findViewById<RadioButton>(R.id.radioButtonGerman)
        radiobuttonGerman.setOnClickListener(this)

        val buttonBack = v.findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener(this)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        return v
    }


    override fun onClick(view: View) {
        val activity = activity

        if (activity != null) {
            when (view.id) {
                R.id.buttonBack -> {
                    startActivity(Intent(activity.applicationContext, StartScreenActivity::class.java))
                }

                R.id.radioButtonEnglish -> {
                    changeApplicationLanguage("ENGLISH")
                }

                R.id.radioButtonSpanish -> {
                    changeApplicationLanguage("SPANISH")
                }

                R.id.radioButtonGerman -> {
                    changeApplicationLanguage("GERMAN")
                }



            }
        }
    }

    private fun changeApplicationLanguage(language:String){
        val sharedPreferencesEditor = sharedPreferences.edit()
        when (language) {
            ENGLISH -> sharedPreferencesEditor?.putString(SELECTED_LANGUAGE, ENGLISH)
            SPANISH -> sharedPreferencesEditor?.putString(SELECTED_LANGUAGE, SPANISH)
            GERMAN -> sharedPreferencesEditor?.putString(SELECTED_LANGUAGE, GERMAN)
        }
    }

}