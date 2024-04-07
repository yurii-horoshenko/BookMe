package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.datasource.BookingRemoteDataSource
import com.gorosoft.bookme.now.data.network.model.response.toDomain
import com.gorosoft.bookme.now.domain.models.PlaceModel
import com.gorosoft.bookme.now.domain.repository.BookingRepositoryProtocol
import com.gorosoft.bookme.now.map

class BookingRepository(
    private val remote: BookingRemoteDataSource,
): BookingRepositoryProtocol {

    override suspend fun getBooking(count: Int): Response<PlaceModel> {
        return remote.getPlaces(count = count).map { it.toDomain() }
    }
}