package com.brainstormideas.apptomar.ui.fragments.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object PasswordUtils {

    private const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"

    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }
}