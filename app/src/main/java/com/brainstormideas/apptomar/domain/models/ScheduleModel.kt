package com.brainstormideas.apptomar.domain.models

import java.util.*

data class ScheduleModel(
    val id: Long,
    val order: OrderModel,
    val exitTime: Date,
    val receivedTime: Date
)