package com.example.customizecars.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.customizecars.R


class DisplayUsernameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_username)

        val username = intent.getStringExtra("com.example.customizecars.USERNAME")
        findViewById<TextView>(R.id.textView).apply {
            text = username

        }
    }


}
