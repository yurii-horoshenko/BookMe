package com.gorosoft.bookme.now.domain.repository

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceModel
import com.gorosoft.bookme.now.domain.models.PlaceType

interface PlaceRepositoryProtocol {

    suspend fun getPlaces(
        query: String? = null,
        type: PlaceType,
        location: LocationModel,
        radius: Int,
    ): Response<PlaceModel>
}
