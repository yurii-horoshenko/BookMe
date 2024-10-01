package com.gorosoft.bookme.now.data.sources.network

import com.gorosoft.bookme.now.domain.models.PlaceModel
import kotlinx.serialization.Serializable

@Serializable
data class PlaceResponse(
    val placeId: String? = null,
    val name: String? = null,
    val description: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val website: String? = null
)

fun PlaceResponse.toDomain(): PlaceModel {
    return PlaceModel(
        placeId = placeId ?: "",
        name = name ?: "",
        description = description ?: "",
        phone = phone ?: "",
        address = address ?: "",
        website = website ?: ""
    )
}