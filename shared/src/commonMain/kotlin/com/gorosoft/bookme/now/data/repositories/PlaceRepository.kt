package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.data.sources.network.datasource.PlaceRemoteDataSource
import com.gorosoft.bookme.now.data.sources.network.ktor.Response
import com.gorosoft.bookme.now.data.sources.network.ktor.map
import com.gorosoft.bookme.now.data.sources.network.toDomain
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceModel
import com.gorosoft.bookme.now.domain.models.PlaceType
import com.gorosoft.bookme.now.domain.repositories.PlaceRepositoryProtocol
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PlaceRepository : PlaceRepositoryProtocol, KoinComponent {

    private val remote: PlaceRemoteDataSource by inject()

    override suspend fun getPlaces(
        query: String?,
        type: PlaceType,
        location: LocationModel,
        radius: Int,
    ): Response<PlaceModel> {
        return remote.getPlaces(
            query = query,
            type = type,
            location = location,
            radius = radius,
        ).map { it.toDomain() }
    }
}
