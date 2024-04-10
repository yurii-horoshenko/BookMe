package com.gorosoft.bookme.now.data.database.datasource

import com.gorosoft.bookme.now.data.database.model.ProfileEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query

class ProfileCacheDataSource(
    private val realm: Realm
) : ProfileCacheDataSourceProtocol {

    override suspend fun getProfile(): ProfileEntity? {
        return realm.query<ProfileEntity>().first().find()
    }

    override suspend fun saveProfile(profile: ProfileEntity): ProfileEntity {
        realm.write {
            val profiles = realm.query<ProfileEntity>().find()
            if (profiles.size > 1 || !profiles.contains(profile)) {
                delete(ProfileEntity::class)
            }
            copyToRealm(profile, updatePolicy = UpdatePolicy.ALL)
        }
        return profile
    }

    override suspend fun clearProfileTable() {
        realm.write {
            delete(ProfileEntity::class)
        }
    }

}