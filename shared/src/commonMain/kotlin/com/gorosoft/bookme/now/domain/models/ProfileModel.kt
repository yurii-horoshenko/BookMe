package com.gorosoft.bookme.now.domain.models

import com.gorosoft.bookme.now.data.sources.network.models.profile.ProfileApi
import com.gorosoft.bookme.now.data.sources.network.models.profile.ProfileGenderType

data class ProfileModel(
    val fullName: String,
    val birthday: Long,
    val gender: ProfileGenderType,
    val phone: String,
    val facebookToken: String?,
    val googleToken: String?,
    val isExist: Boolean,
)

fun ProfileModel.toRequest(): ProfileApi {
    return ProfileApi(
        fullName = fullName,
        phone = phone,
        gender = gender,
        birthday = birthday,
        facebookToken = facebookToken,
        googleToken = googleToken,
        isExist = isExist,
    )
}