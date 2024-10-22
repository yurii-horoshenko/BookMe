package com.gorosoft.bookme.now.data.sources.network.models.place

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PlaceTypeApi {
    @SerialName(value = "barber")
    BARBER,

    @SerialName("beauty_salon")
    BEAUTY_SALON,

    @SerialName("clinic")
    CLINIC,
}