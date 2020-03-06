package com.example.customizecars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
