package com.gorosoft.bookme.now.data.network.model.response

import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    @SerialName("fullname")
    val fullName: String? = null,
    val phone: String? = null,
    val gender: UserGenderType? = null,
    val birthday: Long? = null,
    @SerialName("isExist")
    val isExist: Boolean? = null
)

fun ProfileResponse.toDomain(): ProfileModel {
    return ProfileModel(
        fullName = fullName ?: "",
        phone = phone ?: "",
        gender = gender ?: UserGenderType.OTHER,
        birthday = birthday ?: 0,
        facebookToken = null,
        googleToken = null,
        isExist = isExist ?: false,
    )
}
