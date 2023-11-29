package com.gorosoft.bookme.now.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SuccessResponse(
    @SerialName("access_token")
    val accessToken: String?,
    val success: Boolean? = null
)

@Serializable
data class DataResponse(
    @SerialName("data")
    val data: PlaceResponse? = null
)

@Serializable
data class PlaceResponse(
    @SerialName("nextPageToken")
    val nextPageToken: String? = null
)