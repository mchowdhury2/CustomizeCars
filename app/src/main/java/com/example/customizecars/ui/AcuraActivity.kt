package com.example.customizecars.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class AcuraActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return AcuraFragment()
    }

}
