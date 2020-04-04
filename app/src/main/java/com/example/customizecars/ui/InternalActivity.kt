package com.example.customizecars.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class InternalActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return InternalFragment()
    }
}
