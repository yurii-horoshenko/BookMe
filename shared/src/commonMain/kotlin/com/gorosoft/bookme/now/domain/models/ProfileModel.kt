package com.gorosoft.bookme.now.domain.models

data class ProfileModel(
    val fullName: String,
    val phone: String,
    val gender: UserGenderType,
    val birthday: Long,
    val facebookToken: String?,
    val googleToken: String?,
    val isExist: Boolean
)