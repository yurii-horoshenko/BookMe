package com.gorosoft.bookme.now.data.network.datasource

import com.gorosoft.bookme.now.ResultWrapper
import com.gorosoft.bookme.now.data.network.model.request.CodeRequest
import com.gorosoft.bookme.now.data.network.model.request.ProfileRequest
import com.gorosoft.bookme.now.data.network.model.response.ProfileResponse
import com.gorosoft.bookme.now.data.network.model.response.ProfileTokenResponse
import com.gorosoft.bookme.now.safeCall
import com.gorosoft.bookme.now.safeDataResponseCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse

class UserRemoteDataSource(
    private val client: HttpClient,
) {

    // GET:  base_url/user/login
    suspend fun login(token: String): ResultWrapper<ProfileResponse> {
        val result: HttpResponse = client.get("user/login") {
            bearerAuth(token)
        }
        return safeCall { result.body() }
    }

    // GET:  base_url/user/validation
    suspend fun validation(
        token: String,
        facebookToken: String?,
        googleToken: String?,
        phone: String?
    ): ResultWrapper<ProfileResponse> {
        val result: HttpResponse = client.get("user/validation") {
            bearerAuth(token)
            parameter("facebook_token", facebookToken)
            parameter("google_token", googleToken)
            parameter("phone", phone)
        }
        return safeDataResponseCall { result.body() }
    }

    // POST:  base_url/user/create_profile
    suspend fun createProfile(
        token: String,
        profile: ProfileRequest
    ): ResultWrapper<ProfileResponse> {
        val result: HttpResponse = client.post("user/create_profile") {
            bearerAuth(token)
            setBody(profile)
        }
        return safeDataResponseCall { result.body() }
    }


    // GET:  base_url/user/code
    suspend fun code(
        token: String,
        phone: String,
        resend: Boolean
    ): ResultWrapper<Boolean> {
        val result: HttpResponse = client.get("user/code") {
            bearerAuth(token)
            parameter("phone", phone)
            parameter("resend", resend)
        }
        return safeDataResponseCall { result.body() }
    }

    // POST:  base_url/user/code
    suspend fun code(token: String, code: CodeRequest): ResultWrapper<ProfileTokenResponse> {
        val result: HttpResponse = client.post("user/code") {
            bearerAuth(token)
            setBody(code)
        }
        return safeDataResponseCall { result.body() }
    }
}