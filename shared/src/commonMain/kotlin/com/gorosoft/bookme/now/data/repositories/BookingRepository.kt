package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.datasource.BookingRemoteDataSource
import com.gorosoft.bookme.now.domain.repository.BookingRepositoryProtocol

class BookingRepository(
    private val remote: BookingRemoteDataSource,
): BookingRepositoryProtocol {

    override suspend fun getBooking(count: Int): Response<Any> {
        return TODO()
    }
}