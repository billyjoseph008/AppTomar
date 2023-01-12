package com.brainstormideas.apptomar.data.models

import android.content.ContentValues.TAG
import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
class Owner(
    val id: Long = 0,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val phone: String = "",
    val birthDay: String = "",
    val city: String = "",
    val gender: String = "",
    val address: String = "",
    val country: String = "",
    val picture: String = "",
    val identification: String = "",
    val type: String = ""
) : Parcelable {

    companion object {
        fun DocumentSnapshot.toOwner(): Owner? {
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
                return Owner(
                    id, name, email, password, phone, birthDay, city, gender, address,
                    country, picture, identification, type
                )
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
    }
}