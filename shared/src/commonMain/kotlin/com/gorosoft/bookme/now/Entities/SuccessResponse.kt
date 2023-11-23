package com.gorosoft.bookme.now.Entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SuccessResponse(
    @SerialName("access_token")
    val accessToken: String?,
    val success: Boolean? = null
)