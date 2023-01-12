package com.brainstormideas.apptomar.domain.models

import java.util.*

class ClientModel(
    id: Long,
    name: String,
    email: String,
    password: String,
    phone: String,
    birthDay: Date,
    city: String,
    gender: String,
    address: String,
    country: String,
    photo: String,
    location: LocationModel,
    identification: String,
    type: String
) : User(
    id, name, email, password, phone, birthDay, city, gender, address, country, photo,
    identification, type
)