package com.example.customizecars.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.customizecars.R

class ReviewFragment: Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_review, container, false)
        v.setOnClickListener(this)

        val textreviewyearresult = v.findViewById<TextView>(R.id.textreviewyearresult)
        textreviewyearresult.setText("2020")

        val textreviewmakeresult = v.findViewById<TextView>(R.id.textreviewmakeresult)
        textreviewmakeresult.setText("make")

        val textreviewmodelresult = v.findViewById<TextView>(R.id.textreviewmodelresult)
        textreviewmodelresult.setText("model")

        val textreviewinteriorresult = v.findViewById<TextView>(R.id.textreviewinteriorresult)
        textreviewinteriorresult.setText("Interior")

        val textreviewexteriorresult = v.findViewById<TextView>(R.id.textreviewexteriorresult)
        textreviewexteriorresult.setText("Exterior")

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