package com.gorosoft.bookme.now.domain.repositories

import com.gorosoft.bookme.now.data.sources.network.ktor.Response
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
