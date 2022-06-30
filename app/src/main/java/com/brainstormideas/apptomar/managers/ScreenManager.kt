package com.brainstormideas.apptomar.managers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.brainstormideas.apptomar.constants.Screens
import com.brainstormideas.apptomar.screens.*
import kotlin.reflect.KClass

class ScreenManager(context: Context): AppCompatActivity() {
    var context = context
    fun goToScreen(screen: Screens) {
        var intent = Intent(context, screen.activity).apply{}
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent)
    }
}