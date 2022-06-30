package com.brainstormideas.apptomar.models

data class Store (val id: Int, val name: String, val email: String, val phone: String,
                    val city: String,  val address:  String, val country: String,
                    val owner: Owner, val pictures: Array<String>, val ratings: Array<Rating>,
                    val description: String, val icon: String, val menu: Menu,
                    val location: Location, val deliveryTeam: Array<DeliveryMan>)
