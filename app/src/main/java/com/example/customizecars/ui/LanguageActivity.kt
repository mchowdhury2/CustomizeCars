package com.example.customizecars.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.customizecars.R


class LanguageActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return LanguageFragment()
    }


}
