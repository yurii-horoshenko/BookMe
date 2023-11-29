package com.gorosoft.bookme.now.network_manager.Remote

import com.gorosoft.bookme.now.entities.DataResponse
import com.gorosoft.bookme.now.entities.Location
import com.gorosoft.bookme.now.entities.PLACETYPE
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.path

class PlaceRemoteFlow(private val client: HttpClient) {
    val token = ""

    //GET:  base_url/api/Place/Places
    suspend fun getPlaces(type: PLACETYPE, location: Location, radius: Int): Result<DataResponse> {
        val result: HttpResponse = client.get {
            bearerAuth(token)
            url {
                it.path("Place", "Places")
            }
            parameter("filter", type)
            parameter("lat", location.latitude)
            parameter("lon", location.longitude)
            parameter("radius", radius)
        }

        return runCatching { result.body() }
    }
}
