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

    // GET: base_url/api/Place/Details
    suspend fun getPlaceDetail(placeId: String): Result<DataResponse> {
        val result: HttpResponse = client.get("Place/Details") {
            // bearerAuth(token)
            parameter("placeId", placeId)
        }

        return runCatching { result.body() }
    }
}