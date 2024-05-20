package com.gorosoft.bookme.now.data.network.datasource

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.model.response.BookingResponse
import com.gorosoft.bookme.now.data.network.model.response.PlaceResponse
import com.gorosoft.bookme.now.domain.models.BookingModel
import com.gorosoft.bookme.now.domain.models.PlaceModel
import com.gorosoft.bookme.now.safeDataResponseCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse

class BookingRemoteDataSource(
    private val client: HttpClient,
) {
    // GET: base_url/api/booking/list
    suspend fun getBooking(
        count: Int
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
        dataTime: Long
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
        bookingId: String
    ): Response<Boolean> {
        return safeDataResponseCall {
            val result: HttpResponse = client.get("booking/cancel") {
                parameter("bookingId", bookingId)
            }
            result.body()
        }
    }

}