package com.gorosoft.bookme.now.android.ui.usecase

import android.content.Context
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager

class LogoutUiUseCase(
    private val context: Context
) {

    suspend fun execute() {
        val credentialManager = CredentialManager.create(context)
        val request = ClearCredentialStateRequest()
        credentialManager.clearCredentialState(request)
    }
}
