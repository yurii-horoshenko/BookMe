package com.gorosoft.bookme.now.data.sources.network

import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileRequest(
    @SerialName("fullname")
    val fullName: String? = null,
    val phone: String? = null,
    val gender: UserGenderType? = null,
    val birthday: Long? = null,
    @SerialName("facebook_token")
    val facebookToken: String? = null,
    @SerialName("google_token")
    val googleToken: String? = null,
    @SerialName("isExist")
    val isExist: Boolean? = null,
)

fun ProfileModel.toRequest(): ProfileRequest {
    return ProfileRequest(
        fullName = fullName,
        phone = phone,
        gender = gender,
        birthday = birthday,
        facebookToken = facebookToken,
        googleToken = googleToken,
        isExist = isExist,
    )
}
