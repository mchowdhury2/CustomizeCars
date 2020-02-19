package com.example.customizecars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


const val EXTRA_USERNAME = "com.example.customizecars.USERNAME"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    /** Called when the user taps the Login button */
    fun login(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val username = editText.text.toString()
        val intent = Intent(this, DisplayUsernameActivity::class.java).apply {
            putExtra(EXTRA_USERNAME, username)
        }
        startActivity(intent)
    }

}
