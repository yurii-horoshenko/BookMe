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
    OTHER;
}