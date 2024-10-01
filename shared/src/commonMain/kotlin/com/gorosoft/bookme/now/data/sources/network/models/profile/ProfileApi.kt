package com.gorosoft.bookme.now.data.sources.network.models.profile

import com.gorosoft.bookme.now.data.sources.local.models.profile.ProfileEntity
import com.gorosoft.bookme.now.domain.models.ProfileModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileApi(
    @SerialName("fullname")
    val fullName: String? = null,
    val phone: String? = null,
    val gender: ProfileGenderType? = null,
    val birthday: Long? = null,
    @SerialName("facebook_token")
    val facebookToken: String? = null,
    @SerialName("google_token")
    val googleToken: String? = null,
    @SerialName("isExist")
    val isExist: Boolean? = null,
)

fun ProfileApi.toDomain(): ProfileModel {
    return ProfileModel(
        fullName = fullName ?: "",
        birthday = birthday ?: 0,
        gender = ProfileGenderType.OTHER,
        phone = phone ?: "",
        facebookToken = null,
        googleToken = null,
        isExist = isExist ?: false,
    )
}

fun ProfileApi.toEntity(): ProfileEntity {
    return ProfileEntity(
        fullName = this.fullName ?: "",
        birthday = this.birthday ?: 0,
        gender = this.gender?.name ?: ProfileGenderType.OTHER.name,
        phone = this.phone ?: "",
        isExist = this.isExist ?: false,
    )
}
