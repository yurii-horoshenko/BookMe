package com.gorosoft.bookme.now.domain.usecase

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.repository.ProfileRepositoryProtocol

class LoginUseCase(
    private val profileRepository: ProfileRepositoryProtocol,
) {

    suspend fun execute(): Response<ProfileModel> {
        return profileRepository.login()
    }
}