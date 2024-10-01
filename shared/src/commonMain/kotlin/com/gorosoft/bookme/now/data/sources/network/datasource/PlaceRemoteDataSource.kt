package com.gorosoft.bookme.now.data.sources.network.datasource

import com.gorosoft.bookme.now.data.sources.network.PlaceResponse
import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.ktor.safeDataResponseCall
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceType
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class PlaceRemoteDataSource(
    private val client: HttpClient,
) {
    // GET: base_url/api/place/list
    suspend fun getPlaces(
        query: String? = null,
        type: PlaceType,
        location: LocationModel,
        radius: Int,
    ): Response<PlaceResponse> {
        return safeDataResponseCall {
            val result: HttpResponse = client.get("place/list") {
                // bearerAuth(token)
                parameter("query", query)
                parameter("filter", type)
                parameter("lat", location.latitude)
                parameter("lon", location.longitude)
                parameter("radius", radius)
            }
            result.body()
        }
    }
}
