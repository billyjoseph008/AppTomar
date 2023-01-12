package com.brainstormideas.apptomar.managers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.data.constants.Screens

class ScreenManager(context: Context) : AppCompatActivity() {
    var context = context
    fun goToScreen(screen: Screens) {
        var intent = Intent(context, screen.activity).apply {}
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}