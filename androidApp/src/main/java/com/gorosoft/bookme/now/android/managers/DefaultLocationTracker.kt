package com.gorosoft.bookme.now.android.managers

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.gorosoft.bookme.now.android.ui.utils.unsafeLazy
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class DefaultLocationTracker(
    private val application: Application,
) : LocationTracker {

    private val locationManager by unsafeLazy {
        application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private val locationClient by unsafeLazy {
        LocationServices.getFusedLocationProviderClient(application)
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

    // I am checking for permissions but AS doesn't understand it :)
    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Location? {
        if (!hasAccessCoarseLocationPermission ||
            !hasAccessFineLocationPermission ||
            !isGpsEnabled
        ) {
            return null
        }

        return suspendCancellableCoroutine { cont ->
            locationClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        cont.resume(result)
                    } else {
                        cont.resume(null)
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    println("Location: $it")
                    cont.resume(it)
                }
                addOnFailureListener {
                    cont.resume(null)
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }
    }
}
