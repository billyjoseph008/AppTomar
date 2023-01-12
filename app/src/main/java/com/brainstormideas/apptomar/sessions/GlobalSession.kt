package com.brainstormideas.apptomar.sessions

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Singleton

@Singleton
object GlobalSession {

    private const val USER_ID = "userId"

    fun defaultPreference(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    fun customPreference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.userId
        get() = getString(GlobalSession.USER_ID, "")
        set(value) {
            editMe {
                it.putString(GlobalSession.USER_ID, value)
            }
        }
}