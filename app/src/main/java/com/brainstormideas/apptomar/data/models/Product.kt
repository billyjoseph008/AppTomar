package com.brainstormideas.apptomar.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Long = 0, val name: String = "",
    val branch: String = "", val price: Double = 0.0,
    val amount: Int = 0, val picture: String = "",
    val category: String? = ""
) : Parcelable {


}