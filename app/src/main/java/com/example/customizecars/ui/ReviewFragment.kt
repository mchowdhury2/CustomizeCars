package com.example.customizecars.ui

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import com.example.customizecars.model.AllDbHelper
import com.example.customizecars.model.DBSchema

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


    override fun onStart() {
        super.onStart()

        //val dbHelper = AllDbHelper(this)
       val dbHelper = context?.let { AllDbHelper(it) }

        //val dbHelper = AllDbHelper(context)

        Log.d("Creating", "In Review page, inserting into database.")

        // Gets the data repository in write mode
        val db = dbHelper?.writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
          //  put(DBSchema.ReviewsTable.Cols.USERACCTNO, DEFAULT_BUFFER_SIZE)
            put(DBSchema.ReviewsTable.Cols.YEAR, selectedyear)
            put(DBSchema.ReviewsTable.Cols.MAKE, selectedmake)
            put(DBSchema.ReviewsTable.Cols.MODEL, selectedmodel)
            put(DBSchema.ReviewsTable.Cols.INTDASHCOLOR, valueinterior[0])
            put(DBSchema.ReviewsTable.Cols.INTSCREEN, valueinterior[1])
            put(DBSchema.ReviewsTable.Cols.INTSUNROOF, valueinterior[2])
            put(DBSchema.ReviewsTable.Cols.INTGPS, valueinterior[3])
            put(DBSchema.ReviewsTable.Cols.EXTWHEEL, valueexterior[0])
            put(DBSchema.ReviewsTable.Cols.EXTBUMPERS, valueexterior[1])
            put(DBSchema.ReviewsTable.Cols.EXTENGINE, valueexterior[2])
            put(DBSchema.ReviewsTable.Cols.LOCATION, valueselectedlocation)
        }

        val newRowId = db?.insert(DBSchema.ReviewsTable.TABLENAME, null, values)

    }







    override fun onClick(view: View) {
        val activity = activity

        if (activity != null){
            when (view.getId()){
                R.id.buttonreviewsub -> {
                    val intent = (
                            Intent(
                                activity.applicationContext,
                                StartScreenActivity::class.java
                            )
                            )
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                }
            }
        }
    }
}