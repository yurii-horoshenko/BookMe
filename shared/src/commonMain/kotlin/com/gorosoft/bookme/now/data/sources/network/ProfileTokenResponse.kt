package com.gorosoft.bookme.now.data.sources.network

import com.gorosoft.bookme.now.domain.models.ProfileTokenModel
import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

@Serializable
data class ProfileTokenResponse(
    val accessToken: String? = null,
    val expirationDate: Long? = null,
)

fun ProfileTokenResponse.toDomain(): ProfileTokenModel {
    return ProfileTokenModel(
        accessToken = accessToken ?: "",
        expirationDate = expirationDate ?: Clock.System.now().epochSeconds,
    )
}
