package com.gorosoft.bookme.now.data.sources.network

import com.gorosoft.bookme.now.data.database.model.ProfileEntity
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    @SerialName("fullname")
    val fullName: String? = null,
    val birthday: Long? = null,
    val gender: UserGenderType? = null,
    val email: String? = null,
    val phone: String? = null,
    @SerialName("isExist")
    val isExist: Boolean? = null
)

fun ProfileResponse.toDomain(): ProfileModel {
    return ProfileModel(
        fullName = fullName ?: "",
        birthday = birthday ?: 0,
        gender = UserGenderType.OTHER,
        email = email ?: "",
        phone = phone ?: "",
        facebookToken = null,
        googleToken = null,
        isExist = isExist ?: false,
    )
}

fun ProfileResponse.toEntity(): ProfileEntity {
    return ProfileEntity(
        fullName = this.fullName ?: "",
        birthday = this.birthday ?: 0,
        gender = this.gender?.name ?: UserGenderType.OTHER.name,
        email = this.email ?: "",
        phone = this.phone ?: "",
        isExist = this.isExist ?: false,
    )
}
