package com.gorosoft.bookme.now.domain.models

data class ProfileModel(
    val fullName: String,
    val birthday: Long,
    val gender: UserGenderType,
    val email: String,
    val phone: String,
    val facebookToken: String?,
    val googleToken: String?,
    val isExist: Boolean
)
