package com.gorosoft.bookme.now.data.sources.local.RoomDatabase.Queries.Profile

import com.gorosoft.bookme.now.data.database.model.ProfileEntity

interface ProfileCacheDataSourceProtocol {

    suspend fun getProfile(): ProfileEntity?

    suspend fun saveProfile(profile: ProfileEntity): ProfileEntity

    suspend fun clearProfileTable()
}