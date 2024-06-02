package com.gorosoft.bookme.now.data.network

import com.gorosoft.bookme.now.data.LocalProperties
import com.gorosoft.bookme.now.data.network.headers_holder.HeadersHolderProtocol
import com.gorosoft.bookme.now.data.network.token_holder.TokenHolderProtocol
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorManager(
    private val tokenHolder: TokenHolderProtocol,
    private val headersHolder: HeadersHolderProtocol,
) {
    val client = HttpClient {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = LocalProperties.HOST
                path(LocalProperties.BASE_PATH)
            }
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(Auth) {
            bearer {
                BearerTokens(
                    accessToken = tokenHolder.accessToken.orEmpty(),
                    refreshToken = tokenHolder.refreshToken.orEmpty(),
                )
            }
        }
        headers {
            headersHolder.addHeaders(this)
        }
        HttpResponseValidator {
            validateResponse { response ->
                when (val statusCode = response.status.value) {
                    in 300..399 -> throw ServerException(statusCode, "Redirection error")
                    in 400..499 -> throw ServerException(statusCode, "Client error")
                    in 500..599 -> throw ServerException(statusCode, "Server error")
                }
            }
        }
    }
}