package com.example.customizecars.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.customizecars.R

/**
 * Fragment for splash screen.
 *
 */

class SplashScreenFragment : Fragment(), View.OnTouchListener {
    private var mIsActive = true
    private val mSplashTime = 2000
    private val mTimeIncrement = 100
    private val mSleepTime = 100

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.activity_splash_screen, container, false)
        v.setOnTouchListener(this)
        return v
    }

    override fun onStart() {
        super.onStart()
        // Thread for displaying the SplashScreen
        val splashThread = object : Thread() {
            override fun run() {
                try {
                    var elapsedTime = 0
                    while (mIsActive && elapsedTime < mSplashTime) {
                        Thread.sleep(mSleepTime.toLong())
                        if (mIsActive) elapsedTime = elapsedTime + mTimeIncrement
                    }
                } catch (e: InterruptedException) {
                    // do nothing
                } finally {
                    val activity = activity

                    if (activity != null) {
                        getActivity()!!.finish()
                    }
                    startActivity(Intent("com.example.customizecars.Login"))
                }
            }
        }
        splashThread.start()
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == MotionEvent.ACTION_DOWN) {
            mIsActive = false
            view.performClick()

            return true
        }
        return false
    }
}
