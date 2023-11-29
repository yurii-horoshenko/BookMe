package com.gorosoft.bookme.now.entities

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val longitude: Double,
    val latitude: Double
)