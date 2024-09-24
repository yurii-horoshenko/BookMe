package com.gorosoft.bookme.now.android.ui.usecase

import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.domain.models.ProfileModel
import com.gorosoft.bookme.now.domain.usecase.LoginWithTokenUseCase
import kotlinx.coroutines.tasks.await

class LoginWithGoogleUiUseCase(
    private val loginWithTokenUseCase: LoginWithTokenUseCase,
) {

    suspend fun execute(credential: Credential): Response<ProfileModel> {
        val token: String = getGoogleIdToken(credential)
            ?: return Response.Failure(Exception("Invalid credential"))
        return loginWithTokenUseCase.execute(token)
    }

    private suspend fun getGoogleIdToken(credential: Credential): String? {
        return runCatching {
            if (credential is CustomCredential &&
                credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
            ) {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                val firebaseCredential =
                    GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)
                Firebase.auth.signInWithCredential(firebaseCredential).await()
                googleIdTokenCredential.idToken
            } else {
                error("Invalid credential")
            }
        }.getOrNull()
    }
}
