package com.brainstormideas.apptomar.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
class Client(
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
    val photo: String = "",
    @Serializable(with = Location.Companion::class)
    val location: Location? = null,
    val identification: String = "", val type: String = ""
) : Parcelable {
}