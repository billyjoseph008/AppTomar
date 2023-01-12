package com.brainstormideas.apptomar.core

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.brainstormideas.apptomar.data.models.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.SignInMethodQueryResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class FirebaseAuthHelper : AppCompatActivity() {

    var auth: FirebaseAuth = Firebase.auth

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun login(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("SUCCESS", "loginInWithEmail:success")
                    val user = getCurrentUser()
                } else {
                    Log.w("FAILED", "loginInWithEmail:failure", task.exception)
                }
            }
    }

    fun register(user: User): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("SUCCESS", "createUserWithEmail:success")
                    val user = getCurrentUser()
                    if (!user!!.isEmailVerified) {
                        verifyEmail(user)
                    }
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("FAILED", "createUserWithEmail:failure", task.exception)
                }
            }
    }

    suspend fun checkIfEmailIsAvailable(email: String): Boolean {
        var isNewEmail = false
        if (!email.isNullOrEmpty()) {
            auth.fetchSignInMethodsForEmail(email)
                .addOnCompleteListener(OnCompleteListener<SignInMethodQueryResult> { task ->
                    var isNewUser = task.result.signInMethods!!.isEmpty()
                    if (isNewUser) {
                        Log.e("TAG", "Is New User!")
                        isNewEmail = true
                    } else {
                        Log.e("TAG", "Is Old User!")
                        isNewEmail = false
                    }
                }).await()
        }
        return isNewEmail
    }

    private fun verifyEmail(user: FirebaseUser) {
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.w("SUCCESS", "emailSend:Success", task.exception)
                } else {
                    Log.w("FAILED", "emailNotSend:failure", task.exception)
                }
            }
    }
}