package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R


class SelectyearFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_selectyear, container, false)
        v.setOnClickListener(this)

        val button2020 = v.findViewById<Button>(R.id.button2020)
        button2020.setOnClickListener(this)

        val button2019 = v.findViewById<Button>(R.id.button2019)
        button2019.setOnClickListener(this)

        val button2018 = v.findViewById<Button>(R.id.button2018)
        button2018.setOnClickListener(this)

        val button2017 = v.findViewById<Button>(R.id.button2017)
        button2017.setOnClickListener(this)

        val button2016 = v.findViewById<Button>(R.id.button2016)
        button2016.setOnClickListener(this)

        val button2015 = v.findViewById<Button>(R.id.button2015)
        button2015.setOnClickListener(this)

        return v
    }

    override fun onClick(view: View) {
        val activity = activity

        if (activity != null) {
            when (view.id) {
                R.id.button2020 -> {
                    val intent = (Intent(activity.applicationContext, MakeActivity::class.java))
                    intent.putExtra("selectedyear", "2020")
                    startActivity(intent)
                }

                R.id.button2019 -> {
                    val intent = (Intent(activity.applicationContext, MakeActivity::class.java))
                    intent.putExtra("selectedyear", "2019")
                    startActivity(intent)
                }

                R.id.button2018 -> {
                    val intent = (Intent(activity.applicationContext, MakeActivity::class.java))
                    intent.putExtra("selectedyear", "2018")
                    startActivity(intent)
                }

                R.id.button2017 -> {
                    val intent = (Intent(activity.applicationContext, MakeActivity::class.java))
                    intent.putExtra("selectedyear", "2017")
                    startActivity(intent)
                }

                R.id.button2016 -> {
                    val intent = (Intent(activity.applicationContext, MakeActivity::class.java))
                    intent.putExtra("selectedyear", "2016")
                    startActivity(intent)
                }

                R.id.button2015 -> {
                    val intent = (Intent(activity.applicationContext, MakeActivity::class.java))
                    intent.putExtra("selectedyear", "2015")
                    startActivity(intent)
                }
            }
        }
    }
}



