package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.ResultWrapper
import com.gorosoft.bookme.now.data.network.model.request.CodeRequest
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.ProfileTokenModel

interface UserRepository {

    suspend fun login(): ResultWrapper<ProfileModel>

    suspend fun validation(
        facebookToken: String? = null,
        googleToken: String? = null,
        phone: String? = null
    ): ResultWrapper<ProfileModel>

    suspend fun createProfile(profile: ProfileModel): ResultWrapper<ProfileModel>

    suspend fun code(phone: String, resend: Boolean = false): ResultWrapper<Boolean>

    suspend fun code(code: CodeRequest): ResultWrapper<ProfileTokenModel>
}