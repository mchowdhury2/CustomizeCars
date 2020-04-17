package com.example.customizecars.ui

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import com.example.customizecars.model.AllDbHelper
import com.example.customizecars.model.DBSchema
import kotlinx.android.synthetic.main.activity_settings_edit.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.editEmail
import kotlinx.android.synthetic.main.activity_signup.editName
import kotlinx.android.synthetic.main.activity_signup.editPhoneNumber
import kotlinx.android.synthetic.main.activity_signup.editPostalAddress


class SignUpFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_signup, container, false)
        v.setOnClickListener(this)

        val buttonDone = v.findViewById<Button>(R.id.button)
        buttonDone.setOnClickListener(this)


        return v
    }

    override fun onClick(view: View) {
        val activity = activity

        if (activity != null) {
            when (view.id) {


                R.id.button -> {
                    val userName = editUserName.text.toString()
                    val password = editText2.text.toString()
                    val name = editName.text.toString()
                    val email = editEmail.text.toString()
                    val postalAddress = editPostalAddress.text.toString()
                    val phoneNumber = editPhoneNumber.text.toString()

                    val db = AllDbHelper(requireContext()).writableDatabase
                    val values = ContentValues().apply {
                        put(DBSchema.UsersTable.Cols.NAME, name)
                        put(DBSchema.UsersTable.Cols.EMAIL, email)
                        put(DBSchema.UsersTable.Cols.ADDRESS, postalAddress)
                        put(DBSchema.UsersTable.Cols.PHONE, phoneNumber)
                    }

                    val values2 = ContentValues().apply {
                        put(DBSchema.AccountsTable.Cols.NAME, userName)
                        put(DBSchema.AccountsTable.Cols.PASSWORD, password)
                    }

                    val newRowId = db?.insert(DBSchema.UsersTable.TABLENAME, null, values)
                    val newRowId2 = db?.insert(DBSchema.AccountsTable.TABLENAME, null, values2)


                    startActivity(Intent(activity.applicationContext, LoginActivity::class.java)
                    )


                }
            }
        }
    }
}



