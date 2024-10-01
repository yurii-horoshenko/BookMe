package com.gorosoft.bookme.now.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PlaceType {
    @SerialName(value = "barber")
    BARBER,

    @SerialName("beauty_salon")
    BEAUTY_SALON,

    @SerialName("clinic")
    CLINIC,
}

data class PlaceModel(
    val placeId: String,
    val name: String,
    val description: String,
    val phone: String,
    val address: String,
    val website: String,
)
