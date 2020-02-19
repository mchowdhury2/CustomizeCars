package com.example.customizecars


import android.os.Bundle
import androidx.fragment.app.Fragment

    class SplashScreenActivity: SingleFragmentActivity() {
        override fun createFragment(): Fragment {
        return SplashScreenFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}
