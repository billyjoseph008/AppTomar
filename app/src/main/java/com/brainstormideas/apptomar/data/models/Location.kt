package com.brainstormideas.apptomar.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Parcelize
@Serializable(with = Location.Companion::class)
data class Location(val latitude: Double = 0.0, val length: Double = 0.0) : Parcelable {

    companion object : KSerializer<Location> {

        override val descriptor = PrimitiveSerialDescriptor("Location", PrimitiveKind.DOUBLE)

        override fun serialize(encoder: Encoder, value: Location) {
            val string = value.toString()
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): Location {
            val string = decoder.decodeString()
            println(string)
            return Location(string.toDouble())
        }
    }
}