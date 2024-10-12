package com.gorosoft.bookme.now.data.sources.local.datasource

import com.gorosoft.bookme.now.data.sources.local.models.profile.ProfileEntity

interface ProfileCacheDataSourceProtocol {

    suspend fun getProfile(): ProfileEntity?

    suspend fun saveProfile(profile: ProfileEntity): ProfileEntity

    suspend fun clearProfileTable()
}
