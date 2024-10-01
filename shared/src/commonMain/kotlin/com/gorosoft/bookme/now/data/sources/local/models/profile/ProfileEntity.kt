package com.gorosoft.bookme.now.data.sources.local.models.profile

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gorosoft.bookme.now.data.sources.network.models.profile.ProfileGenderType
import com.gorosoft.bookme.now.domain.models.ProfileModel

@Entity
data class ProfileEntity(
    @PrimaryKey
    val id: Int = 0,
    val fullName: String,
    val birthday: Long,
    val gender: String,
    val phone: String,
    val isExist: Boolean,
)

fun ProfileEntity.toDomain(): ProfileModel {
    return ProfileModel(
        fullName = fullName,
        birthday = birthday,
        gender = ProfileGenderType.entries.find { it.name == this.gender } ?: ProfileGenderType.OTHER,
        phone = phone,
        facebookToken = null,
        googleToken = null,
        isExist = isExist,
    )
}
