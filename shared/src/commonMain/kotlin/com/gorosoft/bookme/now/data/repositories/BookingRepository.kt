package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.datasource.BookingRemoteDataSource
import com.gorosoft.bookme.now.data.network.model.response.toDomain
import com.gorosoft.bookme.now.domain.models.BookingModel
import com.gorosoft.bookme.now.domain.models.PlaceModel
import com.gorosoft.bookme.now.domain.repository.BookingRepositoryProtocol
import com.gorosoft.bookme.now.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BookingRepository: BookingRepositoryProtocol, KoinComponent {

    private val remote: BookingRemoteDataSource by inject()

    override suspend fun getBooking(count: Int): Response<BookingModel> {
        return remote.getBooking(count = count).map { it.toDomain() }
    }

    override suspend fun createBooking(place: PlaceModel, dataTime: Long): Response<Boolean> {
        return remote.createBooking(place = place, dataTime = dataTime)
    }

    override suspend fun cancelBooking(bookingId: String): Response<Boolean> {
        return remote.cancelBooking(bookingId = bookingId)
    }
}