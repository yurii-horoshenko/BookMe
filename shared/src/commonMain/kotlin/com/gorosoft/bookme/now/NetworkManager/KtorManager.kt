package com.gorosoft.bookme.now.NetworkManager

import io.ktor.client.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

final class KtorManager {
    val client = HttpClient {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "ktor.io"
            }
            contentType(ContentType.Application.Json)
        }
    }
}