package com.example.customizecars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class DisplayUsernameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_username)

        val username = intent.getStringExtra("com.example.customizecars.USERNAME")
        findViewById<TextView>(R.id.textView).apply {
            text = username

        }

        val password = intent.getStringExtra("com.example.customizecars.PASSWORD")
        findViewById<TextView>(R.id.textView4).apply {
            text = password

        }
    }


}
