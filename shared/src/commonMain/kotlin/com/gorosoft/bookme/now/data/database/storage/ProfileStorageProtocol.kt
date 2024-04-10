package com.gorosoft.bookme.now.data.database.storage
import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.database.model.Profile
import com.gorosoft.bookme.now.data.network.model.response.ProfileResponse

interface ProfileStorageProtocol {
    suspend fun getProfile(): Profile
    suspend fun saveProfile(profile: ProfileResponse): Profile
}