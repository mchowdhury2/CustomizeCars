package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R

class MakeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_make, container, false)
        v.setOnClickListener(this)

        val buttonacura = v.findViewById<Button>(R.id.buttonacura)
        buttonacura.setOnClickListener(this)

        val buttonbmw = v.findViewById<Button>(R.id.buttonbmw)
        buttonbmw.setOnClickListener(this)

        val buttonhonda = v.findViewById<Button>(R.id.buttonhonda)
        buttonhonda.setOnClickListener(this)

        val buttontoyota = v.findViewById<Button>(R.id.buttontoyota)
        buttontoyota.setOnClickListener(this)

        val buttonford = v.findViewById<Button>(R.id.buttonford)
        buttonford.setOnClickListener(this)

        val buttoninfinity = v.findViewById<Button>(R.id.buttoninfinity)
        buttoninfinity.setOnClickListener(this)

        return v
    }




    override fun onClick(view: View) {

        val activity = activity

        if (activity != null){
            when(view.id){
                R.id.buttonacura -> {
                    startActivity(Intent(activity.applicationContext, AcuraActivity::class.java))
                }
                R.id.buttonbmw -> {
                    startActivity(Intent(activity.applicationContext, BmwActivity::class.java))
                }
                R.id.buttonhonda -> {
                    startActivity(Intent(activity.applicationContext, HondaActivity::class.java))
                }
                R.id.buttontoyota -> {
                    startActivity(Intent(activity.applicationContext, ToyotaActivity::class.java))
                }
                R.id.buttonford -> {
                    startActivity(Intent(activity.applicationContext, FordActivity::class.java))
                }
                R.id.buttoninfinity -> {
                    startActivity(Intent(activity.applicationContext, InfinityActivity::class.java))
                }
            }
        }
    }


}