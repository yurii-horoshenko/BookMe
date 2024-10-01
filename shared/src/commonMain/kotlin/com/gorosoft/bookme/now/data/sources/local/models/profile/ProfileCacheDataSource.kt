package com.gorosoft.bookme.now.data.sources.local.models.profile

class ProfileCacheDataSource(
    private val profileDao: ProfileDao,
) : ProfileCacheDataSourceProtocol {

    override suspend fun getProfile(): ProfileEntity? {
        return profileDao.getProfile()
    }

    override suspend fun saveProfile(profile: ProfileEntity): ProfileEntity {
        profileDao.saveProfile(profile)
        return profile
    }

    override suspend fun clearProfileTable() {
        profileDao.clearProfileTable()
    }
}
