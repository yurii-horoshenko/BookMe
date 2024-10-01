package com.gorosoft.bookme.now.data.sources.network.ktor

interface TokenHolderProtocol {

    var accessToken: String?

    var refreshToken: String?

    fun clearTokens()
}
