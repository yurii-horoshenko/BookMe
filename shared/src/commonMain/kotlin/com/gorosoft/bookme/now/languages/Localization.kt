package com.gorosoft.bookme.now.languages

enum class GENDER(val text: String) {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other")
}

enum class GENERAL(val text: String) {
    OR("or"),
    CONTINUE("Continue")
}

enum class WELCOME(val text: String) {
    PAGE_TITLE("Let’s you in"),
    FACEBOOK_BUTTON("Continue with Facebook"),
    GOOGLE_BUTTON("Continue with Google"),
    SIGN_IN_BUTTON("Sign in with phone")
}

enum class CREATE_PROFILE(val text: String) {
    PAGE_TITLE("Create Your Profile"),
    GENDER_TITLE("Select your gender"),
    GOOGLE_BUTTON("Continue with Google"),
    SIGN_IN_BUTTON("Sign in with phone"),
    SHEET_BIRTHDAY_TITLE("Enter your birthday")
}

enum class ENTER_CODE(val text: String) {
    PAGE_TITLE("Enter code"),
    INFO("Code has been send to "),
    TIMER("Resend code in ")
}

enum class LOGIN(val text: String) {
    PAGE_TITLE("Login to your Account"),
    SIGN_IN_BUTTON("Sign in")
}
