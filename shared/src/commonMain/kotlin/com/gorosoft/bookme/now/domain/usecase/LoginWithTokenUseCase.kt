package com.gorosoft.bookme.now.domain.usecase

import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.repositories.ProfileRepositoryProtocol

class LoginWithTokenUseCase(
    private val profileRepository: ProfileRepositoryProtocol,
) {

    suspend fun execute(token: String): Response<ProfileModel> {
        return profileRepository.loginWithToken(token)
    }
}
