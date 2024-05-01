package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.database.datasource.ProfileCacheDataSourceProtocol
import com.gorosoft.bookme.now.data.database.model.toDomain
import com.gorosoft.bookme.now.data.network.datasource.ProfileRemoteDataSource
import com.gorosoft.bookme.now.data.network.model.request.CodeRequest
import com.gorosoft.bookme.now.data.network.model.request.toRequest
import com.gorosoft.bookme.now.data.network.model.response.toDomain
import com.gorosoft.bookme.now.data.network.model.response.toEntity
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.ProfileTokenModel
import com.gorosoft.bookme.now.domain.repository.ProfileRepositoryProtocol
import com.gorosoft.bookme.now.map

class ProfileRepository(
    private val remote: ProfileRemoteDataSource,
    private val cache: ProfileCacheDataSourceProtocol,
) : ProfileRepositoryProtocol {

    override suspend fun login(): Response<ProfileModel> {
        return remote.login()
            .map { cache.saveProfile(it.toEntity()) }
            .map { it.toDomain() }
    }

    override suspend fun validation(
        facebookToken: String?,
        googleToken: String?,
        phone: String?
    ): Response<ProfileModel> {
        return remote.validation(
            facebookToken = facebookToken,
            googleToken = googleToken,
            phone = phone,
        )
            .map { cache.saveProfile(it.toEntity()) }
            .map { it.toDomain() }
    }

    override suspend fun createProfile(profile: ProfileModel): Response<ProfileModel> {
        return remote.createProfile(profile.toRequest())
            .map { cache.saveProfile(it.toEntity()) }
            .map { it.toDomain() }
    }

    override suspend fun getProfile(): ProfileModel? {
        return cache.getProfile()?.toDomain()
    }

    override suspend fun code(phone: String, resend: Boolean): Response<Boolean> {
        return remote.code(phone = phone, resend = resend).map { it }
    }

    override suspend fun code(code: CodeRequest): Response<ProfileTokenModel> {
        return remote.code(code = code).map { it.toDomain() }
    }
}
