package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.domain.models.BookingModel
import com.gorosoft.bookme.now.domain.models.PlaceModel

interface BookingRepositoryProtocol {

    suspend fun getBooking(count: Int): Response<BookingModel>

    suspend fun createBooking(place: PlaceModel, dataTime: Long): Response<Boolean>

    suspend fun cancelBooking(bookingId: String): Response<Boolean>
}
