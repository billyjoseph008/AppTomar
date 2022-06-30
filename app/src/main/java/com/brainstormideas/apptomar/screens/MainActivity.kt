package com.brainstormideas.apptomar.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.constants.Screens
import com.brainstormideas.apptomar.managers.ScreenManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val screenManager = ScreenManager(applicationContext)

        val splashScreenButton = findViewById(R.id.splashButton) as Button
        splashScreenButton.setOnClickListener{
            screenManager.goToScreen(Screens.SPLASH)
        }
    }
}