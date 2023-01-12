package com.brainstormideas.apptomar.sessions

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object RegisterSession {

    private const val USER_TYPE = "userType"
    private const val USER_NAME = "userName"
    private const val USER_EMAIL = "userEmail"
    private const val USER_PASSWORD = "userPassword"
    private const val USER_SECOND_PASSWORD = "userSecondPassword"
    private const val USER_PHONE = "userPhone"
    private const val USER_ID = "userID"
    private const val USER_COUNTRY = "userCountry"
    private const val USER_COUNTRY_POSITION = "userCountryPosition"
    private const val USER_CITY = "userCity"
    private const val USER_ADDRESS = "userAddress"
    private const val USER_BIRTHDAY = "userBirthDay"
    private const val USER_GENDER = "userGender"

    private const val VEHICLE_BRAND = "vehicleBrand"
    private const val VEHICLE_COLOR = "vehicleBrand"
    private const val VEHICLE_NUMBER = "vehicleNumber"
    private const val VEHICLE_TYPE = "vehicleType"

    private const val STORE_NAME = "storeName"
    private const val STORE_EMAIL = "storeEmail"
    private const val STORE_PHONE = "storePhone"
    private const val STORE_ID = "storeId"
    private const val STORE_COUNTRY = "storeCountry"
    private const val STORE_COUNTRY_POSITION = "userCountryPosition"
    private const val STORE_CITY = "storeCity"
    private const val STORE_ADDRESS = "storeAddress"
    private const val STORE_TYPE = "storeType"

    fun defaultPreference(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    fun customPreference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.userType
        get() = getString(USER_TYPE, "")
        set(value) {
            editMe {
                it.putString(USER_TYPE, value)
            }
        }

    var SharedPreferences.userName
        get() = getString(USER_NAME, "")
        set(value) {
            editMe {
                it.putString(USER_NAME, value)
            }
        }

    var SharedPreferences.userEmail
        get() = getString(USER_EMAIL, "")
        set(value) {
            editMe {
                it.putString(USER_EMAIL, value)
            }
        }

    var SharedPreferences.userPassword
        get() = getString(USER_PASSWORD, "")
        set(value) {
            editMe {
                it.putString(USER_PASSWORD, value)
            }
        }

    var SharedPreferences.userSecondPassword
        get() = getString(USER_SECOND_PASSWORD, "")
        set(value) {
            editMe {
                it.putString(USER_SECOND_PASSWORD, value)
            }
        }

    var SharedPreferences.userPhone
        get() = getString(USER_PHONE, "")
        set(value) {
            editMe {
                it.putString(USER_PHONE, value)
            }
        }

    var SharedPreferences.userID
        get() = getString(USER_ID, "")
        set(value) {
            editMe {
                it.putString(USER_ID, value)
            }
        }
    var SharedPreferences.userCountryPosition
        get() = getInt(USER_COUNTRY_POSITION, 0)
        set(value) {
            editMe {
                it.putInt(USER_COUNTRY_POSITION, value)
            }
        }

    var SharedPreferences.userCountry
        get() = getString(USER_COUNTRY, "")
        set(value) {
            editMe {
                it.putString(USER_COUNTRY, value)
            }
        }

    var SharedPreferences.userCity
        get() = getString(USER_CITY, "")
        set(value) {
            editMe {
                it.putString(USER_CITY, value)
            }
        }

    var SharedPreferences.userAddress
        get() = getString(USER_ADDRESS, "")
        set(value) {
            editMe {
                it.putString(USER_ADDRESS, value)
            }
        }

    var SharedPreferences.userBirthDay
        get() = getString(USER_BIRTHDAY, "")
        set(value) {
            editMe {
                it.putString(USER_BIRTHDAY, value)
            }
        }

    var SharedPreferences.userGender
        get() = getString(USER_GENDER, "male")
        set(value) {
            editMe {
                it.putString(USER_GENDER, value)
            }
        }

    var SharedPreferences.vehicleBrand
        get() = getString(VEHICLE_BRAND, "")
        set(value) {
            editMe {
                it.putString(VEHICLE_BRAND, value)
            }
        }

    var SharedPreferences.vehicleColor
        get() = getString(VEHICLE_COLOR, "")
        set(value) {
            editMe {
                it.putString(VEHICLE_COLOR, value)
            }
        }

    var SharedPreferences.vehicleNumber
        get() = getString(VEHICLE_NUMBER, "")
        set(value) {
            editMe {
                it.putString(VEHICLE_NUMBER, value)
            }
        }

    var SharedPreferences.vehicleType
        get() = getString(VEHICLE_TYPE, "bike")
        set(value) {
            editMe {
                it.putString(VEHICLE_TYPE, value)
            }
        }

    var SharedPreferences.storeName
        get() = getString(STORE_NAME, "")
        set(value) {
            editMe {
                it.putString(STORE_NAME, value)
            }
        }

    var SharedPreferences.storeEmail
        get() = getString(STORE_EMAIL, "")
        set(value) {
            editMe {
                it.putString(STORE_EMAIL, value)
            }
        }

    var SharedPreferences.storePhone
        get() = getString(STORE_PHONE, "")
        set(value) {
            editMe {
                it.putString(STORE_PHONE, value)
            }
        }

    var SharedPreferences.storeId
        get() = getString(STORE_ID, "")
        set(value) {
            editMe {
                it.putString(STORE_ID, value)
            }
        }

    var SharedPreferences.storeCountry
        get() = getString(STORE_COUNTRY, "")
        set(value) {
            editMe {
                it.putString(STORE_COUNTRY, value)
            }
        }

    var SharedPreferences.storeCountryPosition
        get() = getInt(STORE_COUNTRY_POSITION, 0)
        set(value) {
            editMe {
                it.putInt(STORE_COUNTRY_POSITION, value)
            }
        }


    var SharedPreferences.storeCity
        get() = getString(STORE_CITY, "")
        set(value) {
            editMe {
                it.putString(STORE_CITY, value)
            }
        }

    var SharedPreferences.storeAddress
        get() = getString(STORE_ADDRESS, "")
        set(value) {
            editMe {
                it.putString(STORE_ADDRESS, value)
            }
        }

    var SharedPreferences.storeType
        get() = getString(STORE_TYPE, "liquor")
        set(value) {
            editMe {
                it.putString(STORE_TYPE, value)
            }
        }

    var SharedPreferences.clearValues
        get() = { }
        set(value) {
            editMe {
                it.clear()
            }
        }
}
