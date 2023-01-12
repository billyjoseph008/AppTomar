package com.brainstormideas.apptomar.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Rating(
    val client: Client = Client(
        0, "",
        "", "", "", "", "", "", "",
        "", "", Location(0.0, 0.0), "", ""
    ),
    val stars: Int = 0, val comment: String = ""
) : Parcelable
