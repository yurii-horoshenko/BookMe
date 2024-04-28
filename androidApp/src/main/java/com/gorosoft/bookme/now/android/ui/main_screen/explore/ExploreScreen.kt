package com.gorosoft.bookme.now.android.ui.main_screen.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gorosoft.bookme.now.android.annotations.BottomBarNavGraph
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.rememberMultipleLocationPermissionsState
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
    ExploreScreenContent()
}

@Composable
fun ExploreScreenContent() {
    val locationPermission = rememberMultipleLocationPermissionsState()
    var isShowCustomPermissionDialog by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = locationPermission.isLocationPermissionGranted) {
        if (!locationPermission.isLocationPermissionGranted) {
            isShowCustomPermissionDialog = true
        }
    }

    if (isShowCustomPermissionDialog) {
        EnableLocationDialog(
            onEnableLocation = {
                isShowCustomPermissionDialog = false
                locationPermission.launchMultiplePermissionRequest()
            },
            onDismiss = {
                isShowCustomPermissionDialog = false
            }
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (locationPermission.isLocationPermissionGranted) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Location permission granted",
            )
        } else {
            val textToShow = if (locationPermission.shouldShowRationale) {
                "The location is important for this app. Please grant the permission."
            } else {
                "Location permission required for this feature to be available. " +
                        "Please grant the permission"
            }
            Text(
                text = textToShow,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
            )
            Button(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .align(Alignment.Center),
                onClick = {
                    locationPermission.launchMultiplePermissionRequest()
                },
            ) {
                Text("Request permission")
            }
        }
    }
}

@Preview
@Composable
private fun ExploreScreenContentPreview() {
    AppTheme {
        ExploreScreenContent()
    }
}
