package com.gorosoft.bookme.now.data.database.model

import com.bookme.cache.ProfileEntity
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.UserGenderType

fun ProfileEntity.toDomain(): ProfileModel {
    return ProfileModel(
        fullName = fullName,
        birthday = birthday,
        gender = UserGenderType.entries.find { it.name == this.gender } ?: UserGenderType.OTHER,
        email = email,
        phone = phone,
        facebookToken = null,
        googleToken = null,
        isExist = isExist,
    )
}
