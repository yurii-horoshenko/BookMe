package com.gorosoft.bookme.now.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.UserGenderType

@Entity
data class ProfileEntity(
    @PrimaryKey
    val id: Int = 0,
    val fullName: String,
    val birthday: Long,
    val gender: String,
    val email: String,
    val phone: String,
    val isExist: Boolean,
)

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
