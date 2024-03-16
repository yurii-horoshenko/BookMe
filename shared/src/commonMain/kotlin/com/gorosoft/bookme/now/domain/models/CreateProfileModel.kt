package com.gorosoft.bookme.now.domain.models

data class CreateProfileModel(
    val fullName: String? = "",
    val gender: UserGender? = null,
    val dayOfBirth: Int? = null,
    val monthOfBirth: Int? = null,
    val yearOfBirth: Int? = null,
)