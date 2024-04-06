package com.gorosoft.bookme.now.network.repositories

import com.gorosoft.bookme.now.entities.Profile
import com.gorosoft.bookme.now.entities.DataResponse
import com.gorosoft.bookme.now.network.KtorManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse

class UserRepository{
    private val client: HttpClient = KtorManager().client

    // GET:  base_url/user/login
    suspend fun login(): Result<Profile> {
        val token = ""
        val result: HttpResponse = client.get("user/login") {
            bearerAuth(token)
        }

        return runCatching { result.body() }
    }

    // GET:  base_url/user/validation
    suspend fun validation(facebookToken: String? = null, googleToken: String? = null, phone: String? = null): Result<DataResponse> {
        val token = ""
        val result: HttpResponse = client.get("user/validation") {
            bearerAuth(token)
            parameter("facebook_token", facebookToken)
            parameter("google_token", googleToken)
            parameter("phone", phone)
        }

        return runCatching { result.body() }
    }

    // POST:  base_url/user/create_profile
    suspend fun createProfile(profile: Profile): Result<DataResponse> {
        val token = ""

        val result: HttpResponse = client.post("user/validation") {
            bearerAuth(token)
            setBody(profile)
        }

        return runCatching { result.body() }
    }


    // GET:  base_url/user/code
    suspend fun code(phone: String, resend: Boolean = false): Result<DataResponse> {
        val token = ""

        val result: HttpResponse = client.get("user/code") {
            bearerAuth(token)
            parameter("phone", phone)
            parameter("resend", resend)
        }

        return runCatching { result.body() }
    }

    // GET:  base_url/user/code
    suspend fun code(phone: String, code: String): Result<DataResponse> {
        val token = ""

        val result: HttpResponse = client.post("user/code") {
            bearerAuth(token)
            parameter("phone", phone)
            parameter("code", code)
        }

        return runCatching { result.body() }
    }
}