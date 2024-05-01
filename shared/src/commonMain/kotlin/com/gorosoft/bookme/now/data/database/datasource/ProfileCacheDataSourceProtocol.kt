package com.gorosoft.bookme.now.data.database.datasource

import com.bookme.cache.ProfileEntity

interface ProfileCacheDataSourceProtocol {

    suspend fun getProfile(): ProfileEntity?

    suspend fun saveProfile(profile: ProfileEntity): ProfileEntity

    suspend fun clearProfileTable()
}