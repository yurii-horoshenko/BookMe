package com.gorosoft.bookme.now.Repositories

import com.gorosoft.bookme.now.Entities.Location
import com.gorosoft.bookme.now.Entities.PLACETYPE
import com.gorosoft.bookme.now.Interactors.DashboardPresenterContract
import com.gorosoft.bookme.now.NetworkManager.Remote.PlaceRemoteFlow

final class PlaceRepository(private val remoteFlow: PlaceRemoteFlow) {

    suspend fun getPlaces(type: PLACETYPE, location: Location) {
        remoteFlow.getPlaces(type, location)
    }
}