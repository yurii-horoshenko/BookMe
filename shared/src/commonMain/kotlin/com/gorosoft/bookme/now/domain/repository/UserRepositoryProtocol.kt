package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.model.request.CodeRequest
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.ProfileTokenModel

interface UserRepositoryProtocol {

    suspend fun login(): Response<ProfileModel>

    suspend fun validation(
        facebookToken: String? = null,
        googleToken: String? = null,
        phone: String? = null
    ): Response<ProfileModel>

    suspend fun createProfile(profile: ProfileModel): Response<ProfileModel>

    suspend fun code(phone: String, resend: Boolean = false): Response<Boolean>

    suspend fun code(code: CodeRequest): Response<ProfileTokenModel>
}