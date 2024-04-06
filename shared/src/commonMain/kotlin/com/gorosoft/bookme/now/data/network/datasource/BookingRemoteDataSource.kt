package com.gorosoft.bookme.now.data.network.datasource

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.model.response.PlaceResponse
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceType
import com.gorosoft.bookme.now.safeDataResponseCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class BookingRemoteDataSource(
    private val client: HttpClient,
    private val token: String
) {
    // GET: base_url/api/booking/list
    suspend fun getPlaces(
        count: Int
    ): Response<PlaceResponse> {
        val result: HttpResponse = client.get("booking/list") {
            // bearerAuth(token)
            parameter("count", count)
        }

        return safeDataResponseCall { result.body() }
    }
}