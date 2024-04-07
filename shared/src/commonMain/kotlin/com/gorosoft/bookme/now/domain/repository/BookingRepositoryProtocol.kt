package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.domain.models.PlaceModel

interface BookingRepositoryProtocol {

    suspend fun getBooking(
        count: Int
    ): Response<PlaceModel>
}