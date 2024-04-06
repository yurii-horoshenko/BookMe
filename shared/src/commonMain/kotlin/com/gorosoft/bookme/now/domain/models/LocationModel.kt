package com.gorosoft.bookme.now.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class LocationModel(
    val longitude: Double,
    val latitude: Double
)