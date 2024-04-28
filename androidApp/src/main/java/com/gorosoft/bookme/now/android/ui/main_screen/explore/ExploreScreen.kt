@file:OptIn(ExperimentalPermissionsApi::class)

package com.gorosoft.bookme.now.android.ui.main_screen.explore

import android.Manifest
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.gorosoft.bookme.now.android.annotations.BottomBarNavGraph
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.isAllPermissionGranted
import com.gorosoft.bookme.now.android.ui.utils.openAppSystemSettings
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@BottomBarNavGraph
@Destination
@Composable
@Suppress("UnusedParameter")
fun ExploreScreen(
    navigator: DestinationsNavigator,
    viewModel: ExploreViewModel = hiltViewModel(),
) {
    val isShowNavigateToSettingsState =
        viewModel.isShowNavigateToSettingsState.collectAsStateWithLifecycle()
    val isMapVisible = viewModel.isShowMapState.collectAsStateWithLifecycle()
    val isShowLocationRationale = viewModel.isShowLocationRationale.collectAsStateWithLifecycle()
    ExploreScreenContent(
        isShowLocationRationale = isShowLocationRationale.value,
        isShowNavigateToSettingsState = isShowNavigateToSettingsState.value,
        isMapVisible = isMapVisible.value,
        showNavigateToSettings = viewModel::navigateToSettings,
        showMap = viewModel::showMap,
        showLocationRationale = viewModel::showLocationRationale,
    )
}

@ExperimentalPermissionsApi
@Composable
fun ExploreScreenContent(
    isShowLocationRationale: Boolean,
    isShowNavigateToSettingsState: Boolean,
    isMapVisible: Boolean,
    showNavigateToSettings: () -> Unit = {},
    showMap: () -> Unit = {},
    showLocationRationale: (Boolean) -> Unit = { },
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
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Map content",
                )
            }
        }
    }
}

@Preview
@Composable
private fun ExploreScreenContentPreview() {
    AppTheme {
        ExploreScreenContent(
            isShowLocationRationale = false,
            isShowNavigateToSettingsState = false,
            isMapVisible = true,
        )
    }
}

@Preview
@Composable
private fun ExploreScreenContentGoToSettingsPreview() {
    AppTheme {
        ExploreScreenContent(
            isShowLocationRationale = false,
            isShowNavigateToSettingsState = true,
            isMapVisible = false,
        )
    }
}
