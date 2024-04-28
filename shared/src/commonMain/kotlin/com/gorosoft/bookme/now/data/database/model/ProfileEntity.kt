package com.gorosoft.bookme.now.data.database.model

import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.UserGenderType
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class ProfileEntity : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var fullName: String = ""
    var birthday: Long = 0
    var gender: String = ""
    var email: String = ""
    var phone: String = ""
    var isExist: Boolean = false
}

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