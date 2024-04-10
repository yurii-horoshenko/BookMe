package com.gorosoft.bookme.now.data.database.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.SerialName
import org.mongodb.kbson.ObjectId

class Profile() : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var fullName: String = ""
    var phone: String = ""
    var gender: String = ""
    var birthday: Long = 0
    var isExist: Boolean = false
}