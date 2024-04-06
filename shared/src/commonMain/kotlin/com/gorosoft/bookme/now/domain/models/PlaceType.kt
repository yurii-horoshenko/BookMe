package com.gorosoft.bookme.now.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PlaceType {
    @SerialName("barber")
    BARBER,

    @SerialName("beauty_salon")
    BEAUTY_SALON,

    @SerialName("clinic")
    CLINIC
}