package com.brainstormideas.apptomar.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_screen)
    }
}