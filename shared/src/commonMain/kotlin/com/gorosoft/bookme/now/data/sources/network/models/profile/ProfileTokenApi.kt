package com.gorosoft.bookme.now.data.sources.network.models.profile

import com.gorosoft.bookme.now.domain.models.ProfileTokenModel
import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

@Serializable
data class ProfileTokenApi(
    val accessToken: String? = null,
    val expirationDate: Long? = null,
)

fun ProfileTokenApi.toDomain(): ProfileTokenModel {
    return ProfileTokenModel(
        accessToken = accessToken ?: "",
        expirationDate = expirationDate ?: Clock.System.now().epochSeconds,
    )
}
