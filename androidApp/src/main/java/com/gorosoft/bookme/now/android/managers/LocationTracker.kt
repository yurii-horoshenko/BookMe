package com.gorosoft.bookme.now.android.managers

import android.location.Location

interface LocationTracker {

    suspend fun getCurrentLocation(): LocationResult

    sealed class LocationResult {
        data object PermissionsNotGranted : LocationResult()
        data object GpsNotAvailable : LocationResult()
        data object UndefinedLocation : LocationResult()
        data class Success(val currentLocation: Location) : LocationResult()
    }
}
