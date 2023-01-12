package com.brainstormideas.apptomar.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.core.FirebaseAuthHelper
import com.brainstormideas.apptomar.data.constants.Messages
import com.brainstormideas.apptomar.data.constants.Screens
import com.brainstormideas.apptomar.databinding.ActivityLoginScreenBinding
import com.brainstormideas.apptomar.managers.MessagesManager
import com.brainstormideas.apptomar.managers.ScreenManager
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    private val firebaseAuthHelper = FirebaseAuthHelper()
    private lateinit var screenManager: ScreenManager
    private lateinit var messageManager: MessagesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        screenManager = ScreenManager(applicationContext)
        messageManager = MessagesManager(applicationContext)
        setup()
    }

    private fun setup() {

        binding.loginButton.setOnClickListener {
            if (!binding.emailEditText.text.isNullOrEmpty()
                or !binding.registerPasswordEditText.text.isNullOrEmpty()
            ) {

                var loginResult = firebaseAuthHelper.login(
                    binding.emailEditText.text.toString(),
                    binding.registerPasswordEditText.text.toString()
                )
                loginResult.addOnSuccessListener {
                    screenManager.goToScreen(Screens.MAIN)
                }.addOnFailureListener {
                    messageManager.showMessage(Messages.LOGIN_ERROR)
                }
            } else {
                messageManager.showMessage(Messages.LOGIN_ERROR)
            }
        }

        binding.registerButton.setOnClickListener {
            screenManager.goToScreen(Screens.REGISTER)
        }
    }
}