package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.data.sources.local.datasource.ProfileCacheDataSourceProtocol
import com.gorosoft.bookme.now.data.sources.local.models.profile.toDomain
import com.gorosoft.bookme.now.data.sources.network.datasource.ProfileRemoteDataSource
import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.ktor.TokenHolderProtocol
import com.gorosoft.bookme.now.data.sources.network.ktor.map
import com.gorosoft.bookme.now.data.sources.network.models.profile.ProfileCodeApi
import com.gorosoft.bookme.now.data.sources.network.models.profile.toDomain
import com.gorosoft.bookme.now.data.sources.network.models.profile.toEntity
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.models.ProfileTokenModel
import com.gorosoft.bookme.now.domain.models.toRequest
import com.gorosoft.bookme.now.domain.repositories.ProfileRepositoryProtocol
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileRepository : ProfileRepositoryProtocol, KoinComponent {

    private val remote: ProfileRemoteDataSource by inject()
    private val cache: ProfileCacheDataSourceProtocol by inject()
    private val tokenHolder: TokenHolderProtocol by inject()

    override suspend fun login(): Response<ProfileModel> {
        return remote.login()
            .map { cache.saveProfile(it.toEntity()) }
            .map { it.toDomain() }
    }

    override suspend fun loginWithToken(token: String): Response<ProfileModel> {
        tokenHolder.accessToken = token
        return remote.login()
            .map { cache.saveProfile(it.toEntity()) }
            .map { it.toDomain() }
    }

    override suspend fun validation(
        facebookToken: String?,
        googleToken: String?,
        phone: String?,
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
        return remote.code(phone = phone, resend = resend)
            .map { it }
    }

    override suspend fun code(code: ProfileCodeApi): Response<ProfileTokenModel> {
        return remote.code(code = code)
            .map { it.toDomain() }
            .map {
                tokenHolder.accessToken = it.accessToken
                it
            }
    }
}
