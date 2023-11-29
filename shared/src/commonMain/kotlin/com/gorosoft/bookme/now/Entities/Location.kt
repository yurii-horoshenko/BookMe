package com.gorosoft.bookme.now.Entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val longitude: Double,
    val latitude: Double
)