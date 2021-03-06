package com.example.customizecars.ui

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.customizecars.R
import com.example.customizecars.model.AllDbHelper
import com.example.customizecars.model.DBSchema

import kotlinx.android.synthetic.main.activity_login.*


//const val EXTRA_USERNAME = "com.example.customizecars.USERNAME"

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    override fun onStart() {
        super.onStart()
//        val dbHelper = AllDbHelper(this)
//
//        Log.d("Creating", "Printing from the database.")
//
//        // Gets the data repository in write mode
//        val db = dbHelper.writableDatabase
//
//        // Create a new map of values, where column names are the keys
//        val values = ContentValues().apply {
//            put(DBSchema.UsersTable.Cols.NAME, "Akhlak")
//            put(DBSchema.UsersTable.Cols.ADDRESS, "Columbus,OH")
//            put(DBSchema.UsersTable.Cols.EMAIL, "example.##@osu.edu")
//            put(DBSchema.UsersTable.Cols.PHONE, "###-###-####")
//        }
//
//       val newRowId = db?.insert(DBSchema.UsersTable.TABLENAME, null, values)
//
//       val db1 = dbHelper.readableDatabase
//
//        val sortOrder = "${DBSchema.UsersTable.Cols.NAME} DESC"
//
//        val cursor = db.query(
//            DBSchema.UsersTable.TABLENAME,   // The table to query
//            null,             // The array of columns to return (pass null to get all)
//            null,              // The columns for the WHERE clause
//            null,          // The values for the WHERE clause
//            null,                   // don't group the rows
//            null,                   // don't filter by row groups
//            sortOrder               // The sort order
//        )
//        cursor.moveToNext()
//        Log.d("Creating1", cursor.getString(cursor.getColumnIndex("name")))
//
//
//        // New value for one column
//        val newname = "Connor & Tian"
//        val values1 = ContentValues().apply {
//            put(DBSchema.UsersTable.Cols.NAME, newname)
//        }
//
//// Which row to update, based on the title
//        val selection = "${DBSchema.UsersTable.Cols.NAME} LIKE ?"
//        val selectionArgs = arrayOf("Akhlak")
//        val count = db.update(
//            DBSchema.UsersTable.TABLENAME,
//            values1,
//            selection,
//            selectionArgs)
//
//        val cursor1 = db.query(
//            DBSchema.UsersTable.TABLENAME,   // The table to query
//            null,             // The array of columns to return (pass null to get all)
//            null,              // The columns for the WHERE clause
//            null,          // The values for the WHERE clause
//            null,                   // don't group the rows
//            null,                   // don't filter by row groups
//            sortOrder               // The sort order
//        )
//        cursor1.moveToNext()
//        Log.d("Creating2", cursor1.getString(cursor1.getColumnIndex("name")))
//
//        val selection1 = "${DBSchema.UsersTable.Cols.NAME} LIKE ?"
//
//        val selectionArg1 = arrayOf("Connor & Tian")
//
//        val deletedRows = db.delete(DBSchema.UsersTable.TABLENAME, selection, selectionArgs)


    }


    /** Called when the user taps the Login button */
    fun login(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val username = editText.text.toString()
        val password = editText5.text.toString()

        val dbHelper = AllDbHelper(this)
        val db = dbHelper.readableDatabase
        val selection = "${DBSchema.UsersTable.Cols.USERACCTNO} = ?"
        //val selectionArgs = arrayOf(userProfileId)
        val selectionArgs = arrayOf(username)
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
        val grabbedID = cursor.getColumnIndex("acctnumber")
        val grabbedPassword = cursor.getColumnIndex("password")

        if (grabbedPassword.equals(password)){
            MyApplication.userProfileId = grabbedID.toString()
        } else {
            Toast.makeText(applicationContext, "Wrong username or password", Toast.LENGTH_LONG).show()
        }
        val intent = Intent(this, StartScreenActivity::class.java)
        startActivity(intent)
    }

    /** Called when the user taps the Signup button */
    fun signup(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        //val username = editText.text.toString()
        //val password = editText5.text.toString()
        //val intent = Intent(this, DBInsertActivity::class.java).apply {
        //    putExtra("com.example.customizecars.USERNAME", username)
        //}
        //intent.putExtra("com.example.customizecars.PASSWORD", password)


        //val dbHelper = AllDbHelper(this)
        //val db = dbHelper.writableDatabase

        //val values = ContentValues().apply {
        //    put(DBSchema.AccountsTable.Cols.ACCTNO, username)
        //    put(DBSchema.AccountsTable.Cols.PASSWORD, password)
        //}
        //val newRowId = db?.insert(DBSchema.AccountsTable.TABLENAME, null, values)

        startActivity(Intent(applicationContext, SignUpActivity::class.java))
    }

    /** Called when Main activity paused
     * show message to screen */
//    override fun onPause() {
//
//        super.onPause()
//        Toast.makeText(applicationContext, "onPause called", Toast.LENGTH_LONG).show()
//    }

    /** Called when Main activity resumed
     * show message to screen */
//    override fun onResume(){
//        super.onResume()
//        Toast.makeText(applicationContext, "onResume called", Toast.LENGTH_LONG).show()
//    }


    override fun onClick(view: View) {
//        when (view.getId()){
//
//        }
    }
}
