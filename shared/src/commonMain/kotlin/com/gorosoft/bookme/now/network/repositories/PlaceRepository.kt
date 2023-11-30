package com.gorosoft.bookme.now.network.repositories

import com.gorosoft.bookme.now.entities.responses.DataResponse
import com.gorosoft.bookme.now.entities.responses.Location
import com.gorosoft.bookme.now.entities.responses.PLACETYPE
import com.gorosoft.bookme.now.network.remote.PlaceRemoteFlow

class PlaceRepository(private val remoteFlow: PlaceRemoteFlow) {

    suspend fun getPlaces(type: PLACETYPE, location: Location, radius: Int): Result<DataResponse> {
        return remoteFlow.getPlaces(type, location, radius)
    }
}