package com.brainstormideas.apptomar.data.models

import java.util.*

data class Schedule(val id: Long, val order: Order, val exitTime: Date, val receivedTime: Date)