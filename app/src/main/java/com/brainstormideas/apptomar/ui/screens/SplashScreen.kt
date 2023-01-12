package com.brainstormideas.apptomar.ui.screens

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.data.constants.Screens
import com.brainstormideas.apptomar.managers.ScreenManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startTimer()
    }

    fun startTimer() {
        val screenManager = ScreenManager(applicationContext)
        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                screenManager.goToScreen(Screens.LOGIN)
            }

        }.start()
    }
}