package com.gorosoft.bookme.now.data.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataResponse<T>(
    @SerialName("data")
    val data: T,
    val success: Boolean? = null,
    val error: String? = null,
)

@Serializable
data class SuccessResponse(
    val success: Boolean,
    val error: String? = null
)