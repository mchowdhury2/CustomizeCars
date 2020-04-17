package com.example.customizecars.ui

import android.content.ContentValues
import android.content.Context
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

                    if (password != "") {
                        val db = AllDbHelper(requireContext()).writableDatabase
                        val title = password
                        val values = ContentValues().apply {
                            put(DBSchema.AccountsTable.Cols.PASSWORD, password)
                        }
                        val selection = "$(DBSchema.AccountsTable.Cols.PASSWORD) LIKE ?"
                        val selectionArgs = arrayOf("")
                        val count = db.update(
                            DBSchema.AccountsTable.TABLENAME,
                            values,
                            selection,
                            selectionArgs
                        )
                    }

                    if (name != "" || email != "" || postalAddress != "" || phoneNumber != "") {
                        val db = AllDbHelper(requireContext()).writableDatabase
                        val values = ContentValues().apply {
                            if (name != "") {
                                val db = AllDbHelper(requireContext()).writableDatabase
                                val values = ContentValues().apply {
                                    put(DBSchema.UsersTable.Cols.NAME, name)
                                }
                                val selection = "$(DBSchema.UsersTable.Cols.NAME) LIKE ?"
                                val selectionArgs = arrayOf("")
                                val count = db.update(
                                    DBSchema.UsersTable.TABLENAME,
                                    values,
                                    selection,
                                    selectionArgs
                                )
                            }
                            if (email != "") {
                                val db = AllDbHelper(requireContext()).writableDatabase
                                val values = ContentValues().apply {
                                    put(DBSchema.UsersTable.Cols.EMAIL, email)
                                }
                                val selection = "$(DBSchema.UsersTable.Cols.EMAIL) LIKE ?"
                                val selectionArgs = arrayOf("")
                                val count = db.update(
                                    DBSchema.UsersTable.TABLENAME,
                                    values,
                                    selection,
                                    selectionArgs
                                )
                            }
                            if (postalAddress != "") {
                                val db = AllDbHelper(requireContext()).writableDatabase
                                val values = ContentValues().apply {
                                    put(DBSchema.UsersTable.Cols.ADDRESS, postalAddress)
                                }
                                val selection = "$(DBSchema.UsersTable.Cols.ADDRESS) LIKE ?"
                                val selectionArgs = arrayOf("")
                                val count = db.update(
                                    DBSchema.UsersTable.TABLENAME,
                                    values,
                                    selection,
                                    selectionArgs
                                )
                            }
                            if (phoneNumber != "") {
                                val db = AllDbHelper(requireContext()).writableDatabase
                                val values = ContentValues().apply {
                                    put(DBSchema.UsersTable.Cols.PHONE, phoneNumber)
                                }
                                val selection = "$(DBSchema.UsersTable.Cols.PHONE) LIKE ?"
                                val selectionArgs = arrayOf("")
                                val count = db.update(
                                    DBSchema.UsersTable.TABLENAME,
                                    values,
                                    selection,
                                    selectionArgs
                                )
                            }
                        }
                    }

                    startActivity(Intent(activity.applicationContext, SettingsActivity::class.java))
                }

            }
        }
    }
}



