package com.brainstormideas.apptomar.data.models

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
open class User(
    open val id: Long,
    open val name: String,
    open val email: String,
    open val password: String,
    open val phone: String,
    open val birthDay: String,
    open val city: String,
    open val gender: String,
    open val address: String,
    open val country: String,
    open val picture: String,
    open val identification: String,
    open val type: String
) : Parcelable {

    companion object {
        fun DocumentSnapshot.toUser(): User? {
            try {
                val id = getLong("id")!!
                val name = getString("name")!!
                val email = getString("email")!!
                val password = getString("password")!!
                val phone = getString("phone")!!
                val birthDay = getString("birthDay")!!
                val city = getString("city")!!
                val gender = getString("gender")!!
                val address = getString("address")!!
                val country = getString("country")!!
                val picture = getString("picture")!!
                val identification = getString("identification")!!
                val type = getString("type")!!
                return User(
                    id, name, email, password, phone, birthDay, city, gender, address,
                    country, picture, identification, type
                )
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }

        const val TAG = "User"
    }
}