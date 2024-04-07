package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.Response

interface BookingRepositoryProtocol {

    suspend fun getBooking(
        count: Int
    ): Response<Any>
}