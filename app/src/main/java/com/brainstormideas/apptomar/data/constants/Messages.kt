package com.brainstormideas.apptomar.data.constants

enum class Messages(val type: String) {

    //SUCCESS
    LOGIN_SUCCESS("Login successfully"),
    REGISTER_SUCCESS("Registering successfully"),

    //ERRORS
    LOGIN_ERROR("Error login, incorrect user or password."),
    REGISTER_ERROR("Error registering.")


}