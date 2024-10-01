package com.gorosoft.bookme.now.data.sources.network.datasource

import com.gorosoft.bookme.now.data.sources.network.BookingResponse
import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.ktor.safeDataResponseCall
import com.gorosoft.bookme.now.domain.models.PlaceModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class BookingRemoteDataSource(
    private val client: HttpClient,
) {
    // GET: base_url/api/booking/list
    suspend fun getBooking(
        count: Int,
    ): Response<BookingResponse> {
        return safeDataResponseCall {
            val result: HttpResponse = client.get("booking/list") {
                parameter("count", count)
            }
            result.body()
        }
    }

    // POST: base_url/api/booking/create
    suspend fun createBooking(
        place: PlaceModel,
        dataTime: Long,
    ): Response<Boolean> {
        return safeDataResponseCall {
            val result: HttpResponse = client.get("booking/create") {
                parameter("placeId", place.placeId)
                parameter("dataTime", dataTime)
            }
            result.body()
        }
    }

    // POST: base_url/api/booking/cancel
    suspend fun cancelBooking(
        bookingId: String,
    ): Response<Boolean> {
        return safeDataResponseCall {
            val result: HttpResponse = client.get("booking/cancel") {
                parameter("bookingId", bookingId)
            }
            result.body()
        }
    }
}
