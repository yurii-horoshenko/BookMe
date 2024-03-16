package com.gorosoft.bookme.now.network.repositories

import com.gorosoft.bookme.now.entities.CodeRequest
import com.gorosoft.bookme.now.entities.Profile
import com.gorosoft.bookme.now.entities.SuccessResponse
import com.gorosoft.bookme.now.network.KtorManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse

class AuthRepository {
    private val client: HttpClient = KtorManager().client
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
    suspend fun createProfile(profile: Profile): Result<SuccessResponse> {
        val result: HttpResponse = client.get {
            bearerAuth(token)
            setBody(profile)
        }

        return runCatching { result.body() }
    }
}