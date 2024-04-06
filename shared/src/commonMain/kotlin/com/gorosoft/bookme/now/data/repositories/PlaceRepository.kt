package com.gorosoft.bookme.now.data.repositories

import com.gorosoft.bookme.now.ResultWrapper
import com.gorosoft.bookme.now.domain.models.LocationModel
import com.gorosoft.bookme.now.domain.models.PlaceType
import com.gorosoft.bookme.now.data.network.datasource.PlaceRemoteDataSource
import com.gorosoft.bookme.now.domain.repository.PlaceRepository

class PlaceRepositoryImpl(
    private val remote: PlaceRemoteDataSource,
) : PlaceRepository {

    val token = ""

    override suspend fun getPlaces(
        token: String,
        query: String?,
        type: PlaceType,
        location: LocationModel,
        radius: Int,
    ): ResultWrapper<Any> {
        return remote.getPlaces(
            token = token,
            query = query,
            type = type,
            location = location,
            radius = radius
        )
    }
}