package com.brainstormideas.apptomar.managers

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.data.constants.Messages

class MessagesManager(context: Context) : AppCompatActivity() {

    var context = context
    fun showMessage(message: Messages) {
        Log.d("TOAST", "ENTRE")
        Toast.makeText(context, message.type, Toast.LENGTH_SHORT).show()
    }
}