package com.gorosoft.bookme.now.domain.models

data class CreateProfileModel(
    val fullName: String,
    val nickName: String,
    val phone: String,
    val birthdate: Long,
    val gender: UserGender,
    val facebookId: String? = null,
    val googleId: String? = null
)
