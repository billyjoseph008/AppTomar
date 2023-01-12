package com.brainstormideas.apptomar.data.models;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DeliveryManVehicle(
    val vehicleId: Long = 0, val deliveryManId: Long = 0,
    val vehicleNumber: String = "", val vehicleBrand: String = "",
    val vehicleColor: String = "", val vehicleType: String = ""
) : Parcelable {
}

