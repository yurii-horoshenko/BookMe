package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.ResultWrapper
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceType

interface PlaceRepository {

    suspend fun getPlaces(
        token: String,
        query: String? = null,
        type: PlaceType,
        location: LocationModel,
        radius: Int,
    ): ResultWrapper<Any>

}