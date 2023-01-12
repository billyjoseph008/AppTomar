package com.brainstormideas.apptomar.domain.models

import java.util.*

class OwnerModel(
    id: Long, name: String, email: String, password: String, phone: String, birthDay: Date,
    city: String, gender: String, address: String, country: String, photo: String,
    identification: String, type: String
) : User(
    id, name, email, password, phone, birthDay, city, gender, address, country, photo,
    identification, type
)