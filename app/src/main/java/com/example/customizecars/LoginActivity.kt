package com.example.customizecars

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


//const val EXTRA_USERNAME = "com.example.customizecars.USERNAME"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        val dbHelper = AllDbHelper(this)

        Log.d("Creating", "Printing from the database.")

        // Gets the data repository in write mode
        val db = dbHelper.writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(DBSchema.UsersTable.Cols.USERACCTNO, 108)
            put(DBSchema.UsersTable.Cols.NAME, "Akhlak")
            put(DBSchema.UsersTable.Cols.ADDRESS, "Columbus,OH")
            put(DBSchema.UsersTable.Cols.EMAIL, "example.##@osu.edu")
            put(DBSchema.UsersTable.Cols.PHONE, "###-###-####")
        }

       val newRowId = db?.insert(DBSchema.UsersTable.TABLENAME, null, values)

       val db1 = dbHelper.readableDatabase

        val sortOrder = "${DBSchema.UsersTable.Cols.NAME} DESC"

        val cursor = db.query(
            DBSchema.UsersTable.TABLENAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
        )
        cursor.moveToNext()
        Log.d("Creating1", cursor.getString(cursor.getColumnIndex("name")))


        // New value for one column
        val newname = "Connor & Tian"
        val values1 = ContentValues().apply {
            put(DBSchema.UsersTable.Cols.NAME, newname)
        }

// Which row to update, based on the title
        val selection = "${DBSchema.UsersTable.Cols.NAME} LIKE ?"
        val selectionArgs = arrayOf("Akhlak")
        val count = db.update(
            DBSchema.UsersTable.TABLENAME,
            values1,
            selection,
            selectionArgs)

        val cursor1 = db.query(
            DBSchema.UsersTable.TABLENAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
        )
        cursor1.moveToNext()
        Log.d("Creating2", cursor1.getString(cursor1.getColumnIndex("name")))

        val selection1 = "${DBSchema.UsersTable.Cols.NAME} LIKE ?"

        val selectionArg1 = arrayOf("Connor & Tian")

        val deletedRows = db.delete(DBSchema.UsersTable.TABLENAME, selection, selectionArgs)


    }


    /** Called when the user taps the Login button */
    fun login(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val username = editText.text.toString()
        val password = editText5.text.toString()

        val dbHelper = AllDbHelper(this)
        val db = dbHelper.readableDatabase
        val sortOrder = "${DBSchema.AccountsTable.Cols.ACCTNO} DESC"

        val cursor = db.query(
            DBSchema.AccountsTable.TABLENAME,
            null,
            null,
            null,
            null,
            null,
            sortOrder
        )

        //cursor.moveToNext()
        val acctno = cursor.getColumnIndex("acctnumber")

        val intent = Intent(this, DisplayUsernameActivity::class.java).apply {
            putExtra("com.example.customizecars.USERNAME", acctno)
        }
        intent.putExtra("com.example.customizecars.PASSWORD", password)
        startActivity(intent)
    }

    /** Called when the user taps the Signup button */
    fun signup(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val username = editText.text.toString()
        val password = editText5.text.toString()
        val intent = Intent(this, DBInsertActivity::class.java).apply {
            putExtra("com.example.customizecars.USERNAME", username)
        }
        intent.putExtra("com.example.customizecars.PASSWORD", password)
        startActivity(intent)
    }

    /** Called when Main activity paused
     * show message to screen */
    override fun onPause() {

        super.onPause()
        Toast.makeText(applicationContext, "onPause called", Toast.LENGTH_LONG).show()
    }

    /** Called when Main activity resumed
     * show message to screen */
    override fun onResume(){
        super.onResume()
        Toast.makeText(applicationContext, "onResume called", Toast.LENGTH_LONG).show()
    }

}
