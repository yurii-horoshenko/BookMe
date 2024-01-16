package com.gorosoft.bookme.now.network.remote

import com.gorosoft.bookme.now.entities.requests.CodeRequest
import com.gorosoft.bookme.now.entities.requests.ProfileRequest
import com.gorosoft.bookme.now.entities.responses.SuccessResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse

class AuthRemoteFlow(private val client: HttpClient) {
    val token = ""

    // GET: base_url/auth/code
    suspend fun getCode(phone: String, resend: Boolean): Result<SuccessResponse> {
        val result: HttpResponse = client.get {
            bearerAuth(token)
            parameter("phone", phone)
            parameter("resend", resend)
        }

        return runCatching { result.body() }
    }

    // POST: base_url/auth/code
    suspend fun postCode(code: CodeRequest): Result<SuccessResponse> {
        val result: HttpResponse = client.get {
            bearerAuth(token)
            setBody(code)
        }

        return runCatching { result.body() }
    }

    // POST: base_url/auth/create-profile
    suspend fun createProfile(profile: ProfileRequest, resend: Boolean): Result<SuccessResponse> {
        val result: HttpResponse = client.get {
            bearerAuth(token)
            setBody(profile)
        }

        return runCatching { result.body() }
    }
}