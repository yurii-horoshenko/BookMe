package com.gorosoft.bookme.now.domain.usecase

import com.gorosoft.bookme.now.data.sources.network.ktor.TokenHolderProtocol

class IsLoggedInUseCase(
    private val holder: TokenHolderProtocol,
) {

    fun execute(): Boolean {
        return holder.accessToken.isNullOrBlank().not()
    }
}