package com.gorosoft.bookme.now.domain.usecase

import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.repositories.ProfileRepositoryProtocol

class LoginUseCase(
    private val profileRepository: ProfileRepositoryProtocol,
) {

    suspend fun execute(): Response<ProfileModel> {
        return profileRepository.login()
    }
}
