package com.gorosoft.bookme.now.android

enum class NavGraphDestination(val route: String) {
    Splash("splash"),
    Welcome("welcome"),
    Tutorial("tutorial"),
    EnterOtp("enter_otp/{phoneNumber}"),
    CreateProfile("create_profile"),
    Login("login"),
    Main("main"),
    ChooseLanguage("choose_language"),
}
