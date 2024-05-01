package com.gorosoft.bookme.now.data.database.datasource

import com.bookme.cache.Database
import com.bookme.cache.ProfileEntity

class ProfileCacheDataSource(
    private val db: Database
) : ProfileCacheDataSourceProtocol {

    override suspend fun getProfile(): ProfileEntity? {
        return db.getAllProfiles()
    }

    override suspend fun saveProfile(profile: ProfileEntity): ProfileEntity {
        db.insertProfile(profile)
        return profile
    }

    override suspend fun clearProfileTable() {
        db.clearProfileTable()
    }
}