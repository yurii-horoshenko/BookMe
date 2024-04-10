package com.gorosoft.bookme.now.data.database.storage

import com.gorosoft.bookme.now.data.database.model.Profile
import com.gorosoft.bookme.now.data.network.model.response.ProfileResponse
import io.realm.kotlin.query.RealmResults

class ProfileStorage {

    fun getProfile() {
        // all items in the realm
//        val items: RealmResults<Profile> = realm.query<Profile>().find()
    }

    fun saveProfile(profile: ProfileResponse) {
//        realm.write {
//            // Instantiate a new unmanaged Frog object with a RealmInstant property
//            val result = Profile().apply {
//                fullName = profile.fullName
//                phone = profile.phone
//                // Set an initial value with RealmInstant.from() or RealmInstant.now()
////                birthdate = RealmInstant.from(1_577_996_800, 0)
//            }
//            // Copy the object to the realm to return a managed instance
//            copyToRealm(result)
//        }
    }

}