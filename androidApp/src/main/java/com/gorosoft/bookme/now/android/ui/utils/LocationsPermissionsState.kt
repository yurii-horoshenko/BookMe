@file:OptIn(ExperimentalPermissionsApi::class)

package com.gorosoft.bookme.now.android.ui.utils

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState

data class LocationsPermissionsState(
    private val multiplePermissionsState: MultiplePermissionsState,
) : MultiplePermissionsState {

    override val allPermissionsGranted: Boolean
        get() = multiplePermissionsState.allPermissionsGranted

    override val permissions: List<PermissionState>
        get() = multiplePermissionsState.permissions

    override val revokedPermissions: List<PermissionState>
        get() = multiplePermissionsState.revokedPermissions

    override val shouldShowRationale: Boolean
        get() = multiplePermissionsState.shouldShowRationale

    val isLocationPermissionGranted: Boolean
        get() = multiplePermissionsState.permissions.any { it.status.isGranted }

    val isPreciseLocationPermissionGranted: Boolean
        get() = multiplePermissionsState.permissions.any {
            it.permission == ACCESS_FINE_LOCATION && it.status.isGranted
        }

    val isCoarseLocationPermissionGranted: Boolean
        get() = multiplePermissionsState.permissions.any {
            it.permission == ACCESS_COARSE_LOCATION && it.status.isGranted
        }

    override fun launchMultiplePermissionRequest() {
        multiplePermissionsState.launchMultiplePermissionRequest()
    }
}

@Composable
fun rememberMultipleLocationPermissionsState(
    onPermissionsResult: (Map<String, Boolean>) -> Unit = {},
): LocationsPermissionsState {
    val result = rememberMultiplePermissionsState(
        permissions = listOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION),
        onPermissionsResult = onPermissionsResult,
    )
    return remember(key1 = Unit) { LocationsPermissionsState(result) }
}
