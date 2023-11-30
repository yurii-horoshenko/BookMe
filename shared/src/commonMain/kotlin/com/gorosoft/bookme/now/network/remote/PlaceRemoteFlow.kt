package com.gorosoft.bookme.now.network.remote

import com.gorosoft.bookme.now.entities.responses.DataResponse
import com.gorosoft.bookme.now.entities.responses.Location
import com.gorosoft.bookme.now.entities.responses.PLACETYPE
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.path

class PlaceRemoteFlow(private val client: HttpClient) {
    val token = ""

    // GET: base_url/api/Place/Places
    suspend fun getPlaces(type: PLACETYPE, location: Location, radius: Int): Result<DataResponse> {
        val result: HttpResponse = client.get("Place/Places") {
            // bearerAuth(token)
            parameter("filter", type.text)
            parameter("lat", location.latitude)
            parameter("lon", location.longitude)
            parameter("radius", radius)
        }

        return runCatching { result.body() }
    }
}
