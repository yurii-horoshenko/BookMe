package com.gorosoft.bookme.now.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileRequest(
    val fullname: String,
    val phone: String,
    val gender: String,
    val birthday: Long,
    @SerialName("facebook_token")
    val facebookToken: String?,
    @SerialName("google_token")
    val googleToken: String?
)