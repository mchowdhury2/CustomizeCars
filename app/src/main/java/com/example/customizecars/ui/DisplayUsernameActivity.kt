package com.example.customizecars.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

import com.example.customizecars.R

import kotlinx.android.synthetic.main.activity_login.*


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
