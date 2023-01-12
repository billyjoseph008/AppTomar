package com.brainstormideas.apptomar.data.models

import android.os.Parcelable
import android.util.Log
import com.brainstormideas.apptomar.data.constants.NoArgs
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize

@NoArgs
@Parcelize
data class Store(
    val id: Long = 0, val name: String = "",
    val email: String = "", val phone: String = "",
    val city: String = "", val address: String = "",
    val country: String = "", val owner: Owner? = null,
    val pictures: List<String> = emptyList(), val ratings: List<Rating> = emptyList(),
    val description: String = "", val icon: String = "", val menu: Menu? = null,
    val location: Location? = null, val type: String = "",
    val deliveryTeam: List<DeliveryMan> = emptyList()
) : Parcelable {

    companion object {
        fun DocumentSnapshot.toStore(): Store? {
            try {
                val id = getLong("id")!!
                val name = getString("name")!!
                val email = getString("email")!!
                val phone = getString("phone")!!
                val city = getString("city")!!
                val address = getString("address")!!
                val country = getString("country")!!
                val owner = get("owner")!!
                val pictures = get("pictures")!!
                val ratings = get("ratings")!!
                val description = getString("description")!!
                val icon = getString("icon")!!
                val menu = get("menu")!!
                val location = get("location")!!
                val type = getString("type")!!
                val deliveryTeam = get("deliveryTeam")!!
                return Store(
                    id, name, email, phone, city, address, country,
                    owner as Owner, pictures as List<String>,
                    ratings as List<Rating>, description, icon, menu as Menu,
                    location as Location, type, deliveryTeam as List<DeliveryMan>
                )
            } catch (e: Exception) {
                Log.e(TAG, "Error converting store", e)
                return null
            }
        }

        private const val TAG = "Store"
    }


}
