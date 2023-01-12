package com.brainstormideas.apptomar.data.constants

import com.brainstormideas.apptomar.ui.screens.*

enum class Screens(val activity: Class<*>) {
    CATEGORIES(CategoriesScreen::class.java),
    CONFIRMATION(ConfirmationScreen::class.java),
    LOGIN(LoginScreen::class.java),
    MAIN(MainActivity::class.java),
    PAYMENT(PaymentScreen::class.java),
    PROFILE(ProfileScreen::class.java),
    REGISTER(RegisterScreen::class.java),
    RESETPASSWORD(ResetPasswordScreen::class.java),
    SHOPPING(ShoppingCartScreen::class.java),
    SPLASH(SplashScreen::class.java),
    STOREMAP(StoreMapScreen::class.java)
}