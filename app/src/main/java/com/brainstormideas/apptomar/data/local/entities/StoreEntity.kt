package com.brainstormideas.apptomar.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brainstormideas.apptomar.data.models.*

@Entity(tableName = "stores_table")
data class StoreEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "owner") val owner: Owner?,
    @ColumnInfo(name = "pictures") val pictures: List<String>,
    @ColumnInfo(name = "ratings") val ratings: List<Rating>,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "menu") val menu: Menu?,
    @ColumnInfo(name = "location") val location: Location?,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "deliveryTeam") val deliveryTeam: List<DeliveryMan>,
)

fun Store.toEntity() = StoreEntity(
    id = id, name = name, email = email, phone = phone, city = city,
    address = address, country = country, owner = owner, pictures = pictures, ratings = ratings,
    description = description, icon = icon, menu = menu, location = location,
    type = type, deliveryTeam = deliveryTeam
)

fun Store.toDatabase() = StoreEntity(
    id = id, name = name, email = email, phone = phone, city = city,
    address = address, country = country, owner = owner, pictures = pictures, ratings = ratings,
    description = description, icon = icon, menu = menu, location = location,
    type = type, deliveryTeam = deliveryTeam
)