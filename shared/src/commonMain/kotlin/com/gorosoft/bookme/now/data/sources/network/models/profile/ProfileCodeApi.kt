package com.gorosoft.bookme.now.data.sources.network.models.profile

import kotlinx.serialization.Serializable

@Serializable
data class ProfileCodeApi(
    val phone: String,
    val code: String,
)
