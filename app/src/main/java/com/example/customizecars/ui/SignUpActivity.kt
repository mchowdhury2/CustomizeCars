package com.example.customizecars.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.customizecars.R


class SignUpActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return SignUpFragment()
    }


}
