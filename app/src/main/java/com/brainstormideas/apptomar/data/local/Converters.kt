package com.brainstormideas.apptomar.data.local

import androidx.room.TypeConverter
import com.brainstormideas.apptomar.data.models.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromArray(value: Array<String>) = Json.encodeToString(value)

    @TypeConverter
    fun toArray(value: String) = Json.decodeFromString<Array<String>>(value)

    @TypeConverter
    fun fromDate(value: Date) = Json.encodeToString(value)

    @TypeConverter
    fun toDate(value: String) = Json.decodeFromString<Date>(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<String>>(value)

    @TypeConverter
    fun fromList(value: List<String>) = Json.encodeToString(value)

    @TypeConverter
    fun fromRating(value: Rating) = Json.encodeToString(value)

    @TypeConverter
    fun toRating(value: String) = Json.decodeFromString<Rating>(value)

    @TypeConverter
    fun fromListRating(value: List<Rating>) = Json.encodeToString(value)

    @TypeConverter
    fun toListRating(value: String) = Json.decodeFromString<List<Rating>>(value)

    @TypeConverter
    fun fromMenu(value: Menu) = Json.encodeToString(value)

    @TypeConverter
    fun toMenu(value: String) = Json.decodeFromString<Menu>(value)

    @TypeConverter
    fun fromOwner(value: Owner) = Json.encodeToString(value)

    @TypeConverter
    fun toOwner(value: String) = Json.decodeFromString<Owner>(value)

    @TypeConverter
    fun fromLocation(value: Location) = Json.encodeToString(value)

    @TypeConverter
    fun toLocation(value: String) = Json.decodeFromString<Location>(value)

    @TypeConverter
    fun fromDeliveryMan(value: DeliveryMan) = Json.encodeToString(value)

    @TypeConverter
    fun toDeliveryMan(value: String) = Json.decodeFromString<DeliveryMan>(value)

    @TypeConverter
    fun fromListDeliveryMan(value: List<DeliveryMan>) = Json.encodeToString(value)

    @TypeConverter
    fun toListDeliveryMan(value: String) = Json.decodeFromString<List<DeliveryMan>>(value)

}