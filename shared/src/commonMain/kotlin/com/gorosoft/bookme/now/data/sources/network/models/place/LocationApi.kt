package com.gorosoft.bookme.now.data.sources.network.models.place

import kotlinx.serialization.Serializable

@Serializable
data class LocationApi(
    val longitude: Double,
    val latitude: Double,
)
