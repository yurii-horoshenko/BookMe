package com.gorosoft.bookme.now.data.database.datasource

import com.gorosoft.bookme.now.data.database.dao.ProfileDao
import com.gorosoft.bookme.now.data.database.model.ProfileEntity

class ProfileCacheDataSource(
    private val dao: ProfileDao,
) : ProfileCacheDataSourceProtocol {

    override suspend fun getProfile(): ProfileEntity? {
        return dao.getProfile()
    }

    override suspend fun saveProfile(profile: ProfileEntity): ProfileEntity {
        dao.saveProfile(profile)
        return profile
    }

    override suspend fun clearProfileTable() {
        dao.clearProfileTable()
    }
}
