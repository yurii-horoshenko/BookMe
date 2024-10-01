package com.gorosoft.bookme.now.data.sources.network.datasource

import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.ktor.safeDataResponseCall
import com.gorosoft.bookme.now.data.sources.network.models.place.PlaceApi
import com.gorosoft.bookme.now.data.sources.network.models.place.LocationApi
import com.gorosoft.bookme.now.data.sources.network.models.place.PlaceTypeApi
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
        type: PlaceTypeApi,
        location: LocationApi,
        radius: Int,
    ): Response<PlaceApi> {
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
