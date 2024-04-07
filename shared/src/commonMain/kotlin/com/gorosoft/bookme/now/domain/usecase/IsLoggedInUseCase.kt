package com.gorosoft.bookme.now.domain.usecase

import com.gorosoft.bookme.now.managers.KMMUserDefaults

class IsLoggedInUseCase(
    private val defaults: KMMUserDefaults,
) {

    fun execute(): Boolean {
        return defaults.accessToken.isNotBlank()
    }
}