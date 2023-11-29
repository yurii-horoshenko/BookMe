package com.gorosoft.bookme.now.NetworkManager.Remote

import com.gorosoft.bookme.now.Entities.DataResponse
import com.gorosoft.bookme.now.Entities.SuccessResponse
import com.gorosoft.bookme.now.Entities.Location
import com.gorosoft.bookme.now.Entities.PLACETYPE
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

final class PlaceRemoteFlow(private val client: HttpClient) {
    val token = ""

    //GET:  base_url/api/Place/Places
    suspend fun getPlaces(type: PLACETYPE, location: Location): Result<DataResponse> {
        val result: HttpResponse = client.get {
            bearerAuth(token)
            parameter("filter", type)
            parameter("lat", location.latitude)
            parameter("lon", location.longitude)
        }

        return runCatching { result.body() }
    }
}
