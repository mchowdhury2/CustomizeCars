package com.example.customizecars.ui

import android.content.Intent
import android.content.Intent.getIntentOld
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import java.util.zip.Inflater


class MakeFragment : Fragment(), View.OnClickListener {

    lateinit var selectedyear: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.activity_make, container, false)
        v.setOnClickListener(this)

        selectedyear = getActivity()!!.getIntent().getStringExtra("selectedyear")
     //   Log.d("Creating", selectedyear)



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
                    val intent = (Intent(activity.applicationContext, AcuraActivity::class.java))
                    intent.putExtra("selectedyear", selectedyear)
                    startActivity(intent)
                }
                R.id.buttonbmw -> {
                    val intent = (Intent(activity.applicationContext, BmwActivity::class.java))
                    intent.putExtra("selectedyear", selectedyear)
                    startActivity(intent)
                }
                R.id.buttonhonda -> {
                    val intent = (Intent(activity.applicationContext, HondaActivity::class.java))
                    intent.putExtra("selectedyear", selectedyear)
                    startActivity(intent)
                }
                R.id.buttontoyota -> {
                    val intent = (Intent(activity.applicationContext, ToyotaActivity::class.java))
                    intent.putExtra("selectedyear", selectedyear)
                    startActivity(intent)
                }
                R.id.buttonford -> {
                    val intent = (Intent(activity.applicationContext, FordActivity::class.java))
                    intent.putExtra("selectedyear", selectedyear)
                    startActivity(intent)
                }
                R.id.buttoninfinity -> {
                    val intent = (Intent(activity.applicationContext, InfinityActivity::class.java))
                    intent.putExtra("selectedyear", selectedyear)
                    startActivity(intent)
                }
            }
        }
    }


}