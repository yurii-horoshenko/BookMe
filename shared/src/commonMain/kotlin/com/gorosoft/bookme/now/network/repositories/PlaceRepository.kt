package com.gorosoft.bookme.now.network.repositories

import com.gorosoft.bookme.now.entities.DataResponse
import com.gorosoft.bookme.now.entities.Location
import com.gorosoft.bookme.now.entities.PLACETYPE
import com.gorosoft.bookme.now.network.KtorManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class PlaceRepository {
    private val client: HttpClient = KtorManager().client
    val token = ""

    // GET: base_url/api/place/list
    suspend fun getPlaces(query: String? = null, type: PLACETYPE, location: Location, radius: Int, token: String? = null): Result<DataResponse> {
        val result: HttpResponse = client.get("place/list") {
            // bearerAuth(token)
            parameter("query", query)
            parameter("filter", type.text)
            parameter("lat", location.latitude)
            parameter("lon", location.longitude)
            parameter("radius", radius)
            parameter("token", token)
        }

        return runCatching { result.body() }
    }
}