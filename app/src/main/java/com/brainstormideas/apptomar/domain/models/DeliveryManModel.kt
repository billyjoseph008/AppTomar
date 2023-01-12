package com.brainstormideas.apptomar.domain.models

import java.util.*

class DeliveryManModel(
    id: Long, name: String, email: String, password: String, phone: String, city: String,
    gender: String, birthDay: Date, address: String, country: String, photo: String,
    location: LocationModel, identification: String, vehicleNumber: String, type: String
) : User(
    id, name, email, password, phone, birthDay, city, gender, address, country, photo,
    identification, type
)