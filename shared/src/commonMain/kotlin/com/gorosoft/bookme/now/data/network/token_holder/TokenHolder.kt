package com.gorosoft.bookme.now.data.network.token_holder

import com.gorosoft.bookme.now.managers.KMMContext
import com.gorosoft.bookme.now.managers.getString
import com.gorosoft.bookme.now.managers.putString

class TokenHolder(
    private val context: KMMContext,
) : TokenHolderProtocol {

    override var accessToken: String?
        get() = context.getString(ACCESS_TOKEN)
        set(value) {
            context.putString(ACCESS_TOKEN, value)
        }
    override var refreshToken: String?
        get() = context.getString(REFRESH_TOKEN)
        set(value) {
            context.putString(REFRESH_TOKEN, value)
        }

    override fun clearTokens() {
        accessToken = null
        refreshToken = null
    }

    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
    }
}