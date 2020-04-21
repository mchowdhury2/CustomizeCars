package com.example.customizecars.ui


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.customizecars.R
import java.util.*


class LanguageActivity : AppCompatActivity() {

//    override fun createFragment(): Fragment {
//        return LanguageFragment()
//    }
//
//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(ApplicationLanguageHelper.wrap(newBase!!, "fa"))
//    }

    lateinit var changeLangButton : Button
    lateinit var backButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate() // call LoadLocate
        setContentView(R.layout.activity_language)

        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)


        changeLangButton = findViewById(R.id.buttonChangeLang)
        backButton = findViewById(R.id.buttonBack)

        changeLangButton.setOnClickListener {

            showChangeLang()

        }

        backButton.setOnClickListener {

            startActivity(Intent(applicationContext, StartScreenActivity::class.java))

        }

    }

    private fun showChangeLang() {

        val listItmes = arrayOf("French (Français)", "Spanish (Español)", "German (Deutsche)", "English")

        val mBuilder = AlertDialog.Builder(this@LanguageActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            if (which == 0) {
                setLocate("fr")
                recreate()
            } else if (which == 1) {
                setLocate("es")
                recreate()
            } else if (which == 2) {
                setLocate("de")
                recreate()
            } else if (which == 3) {
                setLocate("en")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()

    }

    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }


}
