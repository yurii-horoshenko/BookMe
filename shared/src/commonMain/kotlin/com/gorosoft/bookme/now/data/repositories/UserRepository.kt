package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.ResultWrapper
import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.data.network.datasource.UserRemoteDataSource
import com.gorosoft.bookme.now.data.network.model.request.CodeRequest
import com.gorosoft.bookme.now.data.network.model.request.toRequest
import com.gorosoft.bookme.now.data.network.model.response.toDomain
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.ProfileTokenModel
import com.gorosoft.bookme.now.domain.repository.UserRepositoryProtocol
import com.gorosoft.bookme.now.map

class UserRepository(
    private val remote: UserRemoteDataSource = UserRemoteDataSource(client = KtorManager.client)
) : UserRepositoryProtocol {

    // read token from some secure storage
    private val token = ""

    override suspend fun login(): ResultWrapper<ProfileModel> {
        return remote.login(token).map { it.toDomain() }
    }

    override suspend fun validation(
        facebookToken: String?,
        googleToken: String?,
        phone: String?
    ): ResultWrapper<ProfileModel> {
        return remote.validation(
            token = token,
            facebookToken = facebookToken,
            googleToken = googleToken,
            phone = phone,
        ).map { it.toDomain() }
    }

    override suspend fun createProfile(profile: ProfileModel): ResultWrapper<ProfileModel> {
        return remote.createProfile(token, profile.toRequest()).map { it.toDomain() }
    }

    override suspend fun code(phone: String, resend: Boolean): ResultWrapper<Boolean> {
        return remote.code(token = token, phone = phone, resend = resend).map { it }
    }

    override suspend fun code(code: CodeRequest): ResultWrapper<ProfileTokenModel> {
        return remote.code(token = token, code = code).map { it.toDomain() }
    }
}