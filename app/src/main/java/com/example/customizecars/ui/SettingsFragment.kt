package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R


class SettingsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_settings, container, false)
        v.setOnClickListener(this)

        val buttonEdit = v.findViewById<Button>(R.id.buttonEdit)
        buttonEdit.setOnClickListener(this)

        val buttonDone = v.findViewById<Button>(R.id.buttonDone)
        buttonDone.setOnClickListener(this)


        return v
    }

    override fun onClick(view: View) {
        val activity = activity

        if (activity != null) {
            when (view.id) {

                R.id.buttonEdit -> {
                    startActivity(Intent(activity.applicationContext, SettingsEditActivity::class.java))
                }

                R.id.buttonDone -> {
                    startActivity(Intent(activity.applicationContext, StartScreenActivity::class.java))
                }

            }
        }
    }
}



