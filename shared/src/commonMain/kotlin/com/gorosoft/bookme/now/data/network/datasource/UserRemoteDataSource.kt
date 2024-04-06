package com.gorosoft.bookme.now.data.network.datasource

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.model.request.CodeRequest
import com.gorosoft.bookme.now.data.network.model.request.ProfileRequest
import com.gorosoft.bookme.now.data.network.model.response.ProfileResponse
import com.gorosoft.bookme.now.data.network.model.response.ProfileTokenResponse
import com.gorosoft.bookme.now.safeDataResponseCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse

class UserRemoteDataSource(
    private val client: HttpClient,
) {
    // GET:  base_url/user/login
    suspend fun login(): Response<ProfileResponse> {
        val result: HttpResponse = client.get("user/login")
        return safeDataResponseCall { result.body() }
    }

    // GET:  base_url/user/validation
    suspend fun validation(
        facebookToken: String?,
        googleToken: String?,
        phone: String?
    ): Response<ProfileResponse> {
        val result: HttpResponse = client.get("user/validation") {
            parameter("facebook_token", facebookToken)
            parameter("google_token", googleToken)
            parameter("phone", phone)
        }

        return safeDataResponseCall { result.body() }
    }

    // POST:  base_url/user/create_profile
    suspend fun createProfile(
        profile: ProfileRequest
    ): Response<ProfileResponse> {
        val result: HttpResponse = client.post("user/create_profile") {
            setBody(profile)
        }

        return safeDataResponseCall { result.body() }
    }

    // GET:  base_url/user/code
    suspend fun code(
        phone: String,
        resend: Boolean
    ): Response<Boolean> {
        val result: HttpResponse = client.get("user/code") {
            parameter("phone", phone)
            parameter("resend", resend)
        }

        return safeDataResponseCall { result.body() }
    }

    // POST:  base_url/user/code
    suspend fun code(
        code: CodeRequest
    ): Response<ProfileTokenResponse> {
        val result: HttpResponse = client.post("user/code") {
            setBody(code)
        }

        return safeDataResponseCall { result.body() }
    }
}