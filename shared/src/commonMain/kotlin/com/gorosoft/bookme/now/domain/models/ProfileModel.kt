package com.gorosoft.bookme.now.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class UserGenderType {
    @SerialName("male")
    MALE,

    @SerialName("female")
    FEMALE,

    @SerialName("other")
    OTHER,
}

data class ProfileModel(
    val fullName: String,
    val birthday: Long,
    val gender: UserGenderType,
    val email: String,
    val phone: String,
    val facebookToken: String?,
    val googleToken: String?,
    val isExist: Boolean,
)
