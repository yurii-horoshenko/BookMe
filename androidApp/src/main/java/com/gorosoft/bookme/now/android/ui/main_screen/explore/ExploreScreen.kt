@file:OptIn(ExperimentalPermissionsApi::class)

package com.gorosoft.bookme.now.android.ui.main_screen.explore

import android.Manifest
import android.location.Location
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.annotations.BottomBarNavGraph
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.GpsNotAvailable
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.PermissionsNotGranted
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.Success
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult.UndefinedLocation
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.SearchInput
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.gorosoft.bookme.now.android.ui.utils.isAllPermissionGranted
import com.gorosoft.bookme.now.android.ui.utils.latLng
import com.gorosoft.bookme.now.android.ui.utils.openAppSystemSettings
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

const val ZoomLevel = 15f

@BottomBarNavGraph
@Destination
@Composable
@Suppress("UnusedParameter")
fun ExploreScreen(
    navigator: DestinationsNavigator,
    viewModel: ExploreViewModel = koinViewModel(),
) {
    val isShowNavigateToSettingsState =
        viewModel.isShowNavigateToSettingsState.collectAsStateWithLifecycle()
    val isMapVisible = viewModel.isShowMapState.collectAsStateWithLifecycle()
    val isShowLocationRationale = viewModel.isShowLocationRationale.collectAsStateWithLifecycle()
    val userLocationResult = viewModel.userLocationResult.collectAsStateWithLifecycle()
    val searchText = viewModel.searchText.collectAsStateWithLifecycle()
    ExploreScreenContent(
        isShowLocationRationale = isShowLocationRationale.value,
        isShowNavigateToSettingsState = isShowNavigateToSettingsState.value,
        isMapVisible = isMapVisible.value,
        showNavigateToSettings = viewModel::navigateToSettings,
        showMap = viewModel::showMap,
        showLocationRationale = viewModel::showLocationRationale,
        userLocationResult = userLocationResult.value,
        searchText = searchText.value,
        onValueChanged = viewModel::onSearchTextChange,
    )
}

@ExperimentalPermissionsApi
@Composable
fun ExploreScreenContent(
    isShowLocationRationale: Boolean,
    isShowNavigateToSettingsState: Boolean,
    isMapVisible: Boolean,
    userLocationResult: LocationResult?,
    showNavigateToSettings: () -> Unit = {},
    showMap: () -> Unit = {},
    showLocationRationale: (Boolean) -> Unit = { },
    searchText: String,
    onValueChanged: (String) -> Unit = {},
) {
    val context = LocalContext.current
    if (!LocalInspectionMode.current) {
        val locationPermission = rememberMultiplePermissionsState(
            permissions = listOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            onPermissionsResult = { permissions ->
                if (permissions.values.all { isGranted -> isGranted }) {
                    showMap.invoke()
                } else {
                    showNavigateToSettings.invoke()
                }
            }
        )

        LaunchedEffect(key1 = locationPermission.isAllPermissionGranted) {
            if (locationPermission.isAllPermissionGranted) {
                showMap.invoke()
            } else {
                showLocationRationale.invoke(true)
            }
        }

        if (isShowLocationRationale) {
            EnableLocationDialog(
                onEnableLocation = {
                    showLocationRationale.invoke(false)
                    locationPermission.launchMultiplePermissionRequest()
                },
                onDismiss = {
                    showLocationRationale.invoke(false)
                    showNavigateToSettings.invoke()
                }
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when {
            isShowNavigateToSettingsState -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    EnableLocationContent(context::openAppSystemSettings)
                }
            }

            isMapVisible -> {
                MainContent(
                    userLocationResult = userLocationResult,
                    searchText = searchText,
                    onValueChanged = onValueChanged,
                )
            }
        }
    }
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    userLocationResult: LocationResult? = null,
    searchText: String,
    onValueChanged: (String) -> Unit,
) {
    Box(modifier = modifier.fillMaxSize()) {
        MapContent(userLocationResult = userLocationResult)
        Box(
            modifier = Modifier
                .statusBarsPadding()
                .align(Alignment.TopCenter)
                .padding(24.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(AppTheme.colors.backgroundThemed.backgroundMain)
        ) {
            SearchInput(
                modifier = Modifier
                    .padding(20.dp),
                searchText = searchText,
                onValueChanged = onValueChanged,
                onSearch = { },
            )
        }
    }
}

@Suppress("MagicNumber")
@Composable
private fun BoxScope.MyCurrentLocation(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .align(Alignment.BottomStart)
            .padding(24.dp)
            .clip(CircleShape)
            .debounceClick(onClick = onClick)
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .padding(10.dp)
            .alpha(0.8f)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_current_location_button),
            contentDescription = "",
            colorFilter = ColorFilter.tint(AppTheme.colors.mainColors.primary500),
        )
    }
}

@Composable
private fun MapContent(
    modifier: Modifier = Modifier,
    userLocationResult: LocationResult? = null,
) {
    val cameraPositionState = rememberCameraPositionState {
        if (userLocationResult is Success) {
            position = CameraPosition.fromLatLngZoom(
                userLocationResult.currentLocation.latLng,
                ZoomLevel
            )
        } else {
            return@rememberCameraPositionState
        }
    }

    when (userLocationResult) {
        is Success -> {
            ShowGoogleMap(
                modifier = modifier,
                cameraPositionState = cameraPositionState,
                onMyCurrentLocationClick = {
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(
                        userLocationResult.currentLocation.latLng,
                        ZoomLevel
                    )
                }
            )
        }

        is GpsNotAvailable -> Box {}
        is PermissionsNotGranted -> Box {}
        is UndefinedLocation -> Box {}
        null -> Box {}
    }
}

@Composable
private fun ShowGoogleMap(
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState,
    onMyCurrentLocationClick: () -> Unit = {},
) {
    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            mapType = MapType.NORMAL,
        ),
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        Marker(
            state = MarkerState(
                position = cameraPositionState.position.target,
            ),
            icon = BitmapDescriptorFactory.fromResource(R.drawable.image_map_marker),
            title = "My position",
            snippet = "",
        )
    }
    Box(modifier = Modifier.fillMaxSize()) {
        MyCurrentLocation(onClick = onMyCurrentLocationClick)
    }
}

@Suppress("MagicNumber")
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ExploreScreenContentPreview() {
    AppTheme {
        ExploreScreenContent(
            isShowLocationRationale = false,
            isShowNavigateToSettingsState = false,
            isMapVisible = true,
            userLocationResult = Success(
                Location("Singapore").apply {
                    latitude = 1.3521
                    longitude = 103.8198
                },
            ),
            searchText = ""
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun ExploreScreenContentGoToSettingsPreview() {
    AppTheme {
        ExploreScreenContent(
            isShowLocationRationale = false,
            isShowNavigateToSettingsState = true,
            isMapVisible = false,
            userLocationResult = null,
            searchText = "",
        )
    }
}
