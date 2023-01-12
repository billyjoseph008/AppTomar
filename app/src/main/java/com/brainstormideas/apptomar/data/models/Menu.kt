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
@Serializable(with = Menu.Companion::class)
data class Menu(val products: List<Product>? = emptyList()) : Parcelable {

    companion object : KSerializer<Menu> {

        override val descriptor = PrimitiveSerialDescriptor("Menu", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: Menu) {
            val string = value.toString()
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): Menu {
            val string = decoder.decodeString()
            println("Est es lo que recivo $string")
            return Menu(null)
        }
    }
}