package com.gorosoft.bookme.now.android.managers

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.GpsNotAvailable
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.PermissionsNotGranted
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.Success
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.UndefinedLocation
import com.gorosoft.bookme.now.android.ui.utils.unsafeLazy
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class OneTimeLocationTracker(
    private val application: Application,
    private val locationClient: FusedLocationProviderClient,
) : LocationTracker {

    private val locationManager by unsafeLazy {
        application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private val hasAccessFineLocationPermission
        get() = ActivityCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private val hasAccessCoarseLocationPermission
        get() = ActivityCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private val isGpsEnabled
        get() = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

    private val hasLocationPermissions
        get() = hasAccessFineLocationPermission &&
                hasAccessCoarseLocationPermission

    // I am checking for permissions but AS doesn't understand it :)
    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): LocationResult {
        when {
            hasLocationPermissions.not() -> return PermissionsNotGranted
            isGpsEnabled.not() -> return GpsNotAvailable
        }

        return suspendCancellableCoroutine { continuation ->
            val cancellationTokenSource = CancellationTokenSource()
            locationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                cancellationTokenSource.token
            ).apply {
                if (isComplete) {
                    if (isSuccessful) {
                        continuation.resume(Success(result))
                    } else {
                        continuation.resume(UndefinedLocation)
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener { location: Location ->
                    continuation.resume(Success(location))
                    cancellationTokenSource.cancel()
                }
                addOnFailureListener {
                    continuation.resume(UndefinedLocation)
                    cancellationTokenSource.cancel()
                }
                addOnCanceledListener {
                    cancellationTokenSource.cancel()
                    continuation.cancel()
                }
            }
        }
    }
}
