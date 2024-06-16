package com.gorosoft.bookme.now.data.network.token_holder

interface TokenHolderProtocol {

    var accessToken: String?

    var refreshToken: String?

    fun clearTokens()
}