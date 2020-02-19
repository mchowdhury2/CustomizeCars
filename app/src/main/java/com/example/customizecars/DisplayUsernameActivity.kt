package com.example.customizecars

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.customizecars.R

class DisplayUsernameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_username)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = username
        }
    }
}
