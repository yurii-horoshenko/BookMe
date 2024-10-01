package com.gorosoft.bookme.now.domain.repositories

import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.models.profile.ProfileCodeApi
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.ProfileTokenModel

interface ProfileRepositoryProtocol {

    suspend fun login(): Response<ProfileModel>

    suspend fun loginWithToken(token: String): Response<ProfileModel>

    suspend fun validation(
        facebookToken: String? = null,
        googleToken: String? = null,
        phone: String? = null,
    ): Response<ProfileModel>

    suspend fun createProfile(profile: ProfileModel): Response<ProfileModel>

    suspend fun getProfile(): ProfileModel?

    suspend fun code(phone: String, resend: Boolean = false): Response<Boolean>

    suspend fun code(code: ProfileCodeApi): Response<ProfileTokenModel>
}
