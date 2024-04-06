package com.gorosoft.bookme.now.network.repositories

import com.gorosoft.bookme.now.entities.PlaceInfoResponse
import com.gorosoft.bookme.now.network.KtorManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class BookingRepository {
    private val client: HttpClient = KtorManager().client
    val token = ""

    // GET: base_url/api/booking/list
    suspend fun getBooking(count: Int): Result<Array<PlaceInfoResponse>> {
        val result: HttpResponse = client.get("booking/list") {
            // bearerAuth(token)
            parameter("count", count)
        }

        return runCatching { result.body() }
    }
}