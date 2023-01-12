package com.brainstormideas.apptomar.data.models

import java.util.*

data class Order(
    val id: Long, val date: Date, val products: Array<Product>, val payment: Payment,
    val deliveryMan: DeliveryMan, val schedule: Schedule, val user: User,
    val store: Store
)