package com.gorosoft.bookme.now.network_manager.Repositories

import com.gorosoft.bookme.now.entities.DataResponse
import com.gorosoft.bookme.now.entities.Location
import com.gorosoft.bookme.now.entities.PLACETYPE
import com.gorosoft.bookme.now.network_manager.Remote.PlaceRemoteFlow

class PlaceRepository(private val remoteFlow: PlaceRemoteFlow) {

    suspend fun getPlaces(type: PLACETYPE, location: Location, radius: Int): Result<DataResponse> {
        return remoteFlow.getPlaces(type, location, radius)
    }
}