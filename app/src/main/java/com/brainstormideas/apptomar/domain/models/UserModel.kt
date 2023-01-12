package com.brainstormideas.apptomar.domain.models


import com.brainstormideas.apptomar.data.local.entities.UserEntity
import com.brainstormideas.apptomar.data.models.User
import java.util.*

open class User(
    val id: Long, val name: String, val email: String,
    val password: String, val phone: String, val birthDay: Date,
    val city: String, val gender: String, val address: String,
    val country: String, val picture: String, val identification: String,
    val type: String
)

fun User.toDomain() = User(
    id, name, email,
    password, phone, birthDay, city, gender, address,
    country, picture, identification, type
)

fun UserEntity.toDomain() = User(
    id, name, email,
    password, phone, birthDay, city, gender, address,
    country, picture, identification, type
)