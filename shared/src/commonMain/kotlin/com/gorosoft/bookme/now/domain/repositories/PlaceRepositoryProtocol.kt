package com.gorosoft.bookme.now.domain.repositories

import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.models.place.LocationApi
import com.gorosoft.bookme.now.data.sources.network.models.place.PlaceTypeApi
import com.gorosoft.bookme.now.domain.models.PlaceModel

interface PlaceRepositoryProtocol {

    suspend fun getPlaces(
        query: String? = null,
        type: PlaceTypeApi,
        location: LocationApi,
        radius: Int,
    ): Response<PlaceModel>
}
