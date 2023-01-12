package com.brainstormideas.apptomar.domain.models

import com.brainstormideas.apptomar.data.local.entities.StoreEntity
import com.brainstormideas.apptomar.data.models.Store

data class StoreModel(
    val id: Int, val name: String, val email: String, val phone: String,
    val city: String, val address: String, val country: String,
    val owner: OwnerModel, val pictures: List<String>, val ratings: List<RatingModel>,
    val description: String, val icon: String, val menu: MenuModel,
    val location: LocationModel, val deliveryTeam: List<DeliveryManModel>
)

fun Store.toDomain() = Store(
    id,
    name, email,
    phone, city,
    address, country,
    owner, pictures,
    ratings, description,
    icon, menu,
    location, type,
    deliveryTeam
)

fun StoreEntity.toDomain() = Store(
    id,
    name, email,
    phone, city,
    address, country,
    owner, pictures,
    ratings, description,
    icon, menu,
    location, type,
    deliveryTeam
)
