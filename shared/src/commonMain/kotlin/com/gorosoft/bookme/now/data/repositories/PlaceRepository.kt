package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.Response
import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceType
import com.gorosoft.bookme.now.domain.models.PlaceModel
import com.gorosoft.bookme.now.data.network.datasource.PlaceRemoteDataSource
import com.gorosoft.bookme.now.data.network.model.response.toDomain
import com.gorosoft.bookme.now.domain.repository.PlaceRepositoryProtocol
import com.gorosoft.bookme.now.map

class PlaceRepository(
    private val remote: PlaceRemoteDataSource = PlaceRemoteDataSource(
        client = KtorManager.client,
        token = ""
    ),
) : PlaceRepositoryProtocol {

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
            radius = radius
        ).map { it.toDomain() }
    }
}