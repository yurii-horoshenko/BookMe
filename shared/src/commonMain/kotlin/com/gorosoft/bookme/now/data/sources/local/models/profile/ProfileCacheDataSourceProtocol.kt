package com.gorosoft.bookme.now.data.sources.local.models.profile

interface ProfileCacheDataSourceProtocol {

    suspend fun getProfile(): ProfileEntity?

    suspend fun saveProfile(profile: ProfileEntity): ProfileEntity

    suspend fun clearProfileTable()
}
