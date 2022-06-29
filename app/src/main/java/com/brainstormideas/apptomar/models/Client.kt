package com.brainstormideas.apptomar.models

class Client(id: Int, name: String, email: String, password: String, phone: String, city: String,
             address: String, country: String)
        : User(id, name, email, password, phone, city, address, country)