package com.brainstormideas.apptomar.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.data.constants.Screens
import com.brainstormideas.apptomar.databinding.ActivityRegisterScreenBinding
import com.brainstormideas.apptomar.managers.MessagesManager
import com.brainstormideas.apptomar.managers.ScreenManager
import dagger.hilt.android.AndroidEntryPoint

const val REGISTER_PREFERENCE = "REGISTER_PREFERENCE"
const val INPUT_DATA = "inputData"
const val CLIENT = "client"
const val DELIVERY = "delivery"
const val STORE = "store"

@AndroidEntryPoint
class RegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterScreenBinding
    private lateinit var screenManager: ScreenManager
    private lateinit var messageManager: MessagesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        screenManager = ScreenManager(applicationContext)
        messageManager = MessagesManager(applicationContext)
        setup()
    }

    private fun setup() {
        binding.backButton.setOnClickListener {
            screenManager.goToScreen(Screens.LOGIN)
        }
    }
}