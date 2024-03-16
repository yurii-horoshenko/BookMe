package com.gorosoft.bookme.now.network.repositories

import com.gorosoft.bookme.now.entities.Profile
import com.gorosoft.bookme.now.entities.DataResponse
import com.gorosoft.bookme.now.network.KtorManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class UserRepository{
    private val client: HttpClient = KtorManager().client

    // GET:  base_url/user/login
    // Header: “Authorization” : {access_token}
    suspend fun login(): Result<Profile> {
        val token = ""
        val result: HttpResponse = client.get("user/login") {
            bearerAuth(token)
        }
        // Response:
        // {
        //    “fullname”: “Daniel Austin”,
        //    “phone”: “+1111467378399”,
        //    “gender”: “male”,
        //    “birthday”: 567602526000,
        //    “success”: true
        // }
        return runCatching { result.body() }
    }

    // GET:  base_url/user/validation
    // Header: “Authorization” : {static_JTW_auth_token}
    suspend fun validation(token: String): Result<DataResponse> {
        val token = ""
        val result: HttpResponse = client.get("user/validation") {
            bearerAuth(token)
        }
        // Response:
        // {
        //    “fullname”: “Daniel Austin”,
        //    “phone”: “+1111467378399”,
        //    “gender”: “male”,
        //    “birthday”: 567602526000,
        //    “success”: true
        // }
        return runCatching { result.body() }
    }
}