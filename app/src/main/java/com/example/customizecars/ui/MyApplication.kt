package com.example.customizecars.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MyApplication : Application() {

    companion object {
        var userProfileId = ""
    }

    override fun onCreate() {
        super.onCreate()
    }

}
