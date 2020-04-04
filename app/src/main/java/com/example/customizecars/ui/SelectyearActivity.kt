package com.example.customizecars.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.customizecars.R

class SelectyearActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return SelectyearFragment()
    }

}
