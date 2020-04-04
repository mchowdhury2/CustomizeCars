package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R


class StartScreenFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_start_screen, container, false)
        v.setOnClickListener(this)

        val buttonStart = v.findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener(this)

        //val load = v.findViewById<Button>(R.id.load)
        //load.setOnClickListener(this)

        //val settings = v.findViewById<Button>(R.id.settings)
        //settings.setOnClickListener(this)

        return v
    }

    override fun onClick(view: View) {
        val activity = activity

        if (activity != null) {
            when (view.id) {
                R.id.buttonStart -> {
                    startActivity(Intent(activity.applicationContext, SelectyearActivity::class.java))
                }

                //R.id.load -> {
                //    startActivity(Intent(activity.applicationContext, MakeActivity::class.java))
                //}

                //R.id.settings -> {
                //    startActivity(Intent(activity.applicationContext, MakeActivity::class.java))
                //}
            }
        }
    }
}



