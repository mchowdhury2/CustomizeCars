package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import kotlinx.android.synthetic.main.activity_settings_edit.*


class SettingsEditFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_settings_edit, container, false)
        v.setOnClickListener(this)

        val buttonSaveExit = v.findViewById<Button>(R.id.buttonSaveExit)
        buttonSaveExit.setOnClickListener(this)


        return v
    }

    override fun onClick(view: View) {
        val activity = activity

        if (activity != null) {
            when (view.id) {
                R.id.buttonSaveExit -> {
                    val password = editPassword.text.toString()
                    val name = editName.text.toString()
                    val email = editEmail.text.toString()
                    val postalAddress = editPostalAddress.text.toString()
                    val phoneNumber = editPhoneNumber.text.toString()

                    startActivity(Intent(activity.applicationContext, SettingsActivity::class.java))
                }

            }
        }
    }
}



