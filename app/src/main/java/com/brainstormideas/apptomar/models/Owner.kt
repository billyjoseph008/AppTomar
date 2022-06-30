package com.brainstormideas.apptomar.models

class Owner(id: Int, name: String, email: String, password: String, phone: String,
            city: String, address: String, country: String, photo: String)
        : User(id, name, email, password, phone, city, address, country, photo)