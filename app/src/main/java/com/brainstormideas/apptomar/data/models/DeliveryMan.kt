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
@Serializable(with = DeliveryMan.Companion::class)
class DeliveryMan(
    val id: Long = 0,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val phone: String = "",
    val city: String = "",
    val gender: String = "",
    val birthDay: String = "",
    val address: String = "",
    val country: String = "",
    val photo: String = "",
    val location: Location? = null,
    val identification: String = "",
    val vehicle: DeliveryManVehicle = DeliveryManVehicle(0, 0, "", "", "", ""),
    val type: String = ""
) : Parcelable {

    companion object : KSerializer<DeliveryMan> {

        override val descriptor = PrimitiveSerialDescriptor("DeliveryMan", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: DeliveryMan) {
            val string = value.toString()
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): DeliveryMan {
            val string = decoder.decodeString()
            println("Est es lo que recivo $string")
            return DeliveryMan()
        }
    }

}