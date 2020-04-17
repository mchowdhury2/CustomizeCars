package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import com.example.customizecars.model.AllDbHelper
import com.example.customizecars.model.DBSchema
import com.example.customizecars.ui.MyApplication.Companion.userProfileId


class SettingsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_settings, container, false)
        v.setOnClickListener(this)

        val dbHelper = AllDbHelper(requireContext())

        val db = dbHelper.readableDatabase
        val selection = "${DBSchema.UsersTable.Cols.USERACCTNO} = ?"
        //val selectionArgs = arrayOf(userProfileId)
        val selectionArgs = arrayOf(MyApplication.userProfileId.toString())
        val sortOrder = "${DBSchema.UsersTable.Cols.USERACCTNO} DESC"

        val cursor = db.query(
            DBSchema.UsersTable.TABLENAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )

        //cursor.moveToNext()
        val name = cursor.getColumnIndex("name")
        val email = cursor.getColumnIndex("address")
        val phoneNumber = cursor.getColumnIndex("phone")
        val postalAddress = cursor.getColumnIndex("address")





        val textEmail = v.findViewById<TextView>(R.id.textEmail)
        textEmail.setText(email)

        val textName = v.findViewById<TextView>(R.id.textView11)
        textName.setText(name)

        val textPhone = v.findViewById<TextView>(R.id.textView10)
        textPhone.setText(phoneNumber)

        val textPostalAddress = v.findViewById<TextView>(R.id.textView9)
        textPostalAddress.setText(postalAddress)




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



