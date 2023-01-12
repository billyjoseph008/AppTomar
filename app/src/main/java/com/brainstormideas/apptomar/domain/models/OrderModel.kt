package com.brainstormideas.apptomar.domain.models

import java.util.*

data class OrderModel(
    val id: Long, val date: Date, val products: Array<ProductModel>, val payment: PaymentModel,
    val deliveryMan: DeliveryManModel, val schedule: ScheduleModel, val user: User,
    val store: StoreModel
)