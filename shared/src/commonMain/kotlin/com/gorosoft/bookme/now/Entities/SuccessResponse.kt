package com.gorosoft.bookme.now.Entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encoding.AbstractDecoder

@Serializable
data class SuccessResponse(
    @SerialName("access_token")
    val accessToken: String?,
    val success: Boolean? = null
)

@Serializable
data class DataResponse(
    val data: PlaceResponse? = null
)

@Serializable
data class PlaceResponse(
    val nextPageToken: String? = null
)