package com.brainstormideas.apptomar.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brainstormideas.apptomar.data.models.User

@Entity(tableName = "users_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "birthDay") val birthDay: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "picture") val picture: String,
    @ColumnInfo(name = "identification") val identification: String,
    @ColumnInfo(name = "type") val type: String
)

fun User.toEntity() = UserEntity(
    name = name, email = email, password = password, phone = phone,
    birthDay = birthDay, city = city, gender = gender, address = address,
    country = country, picture = picture, identification = identification,
    type = type
)