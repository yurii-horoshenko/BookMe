package com.gorosoft.bookme.now.entities.responses

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val longitude: Double,
    val latitude: Double
)