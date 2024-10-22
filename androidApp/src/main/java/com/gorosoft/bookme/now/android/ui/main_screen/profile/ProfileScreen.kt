package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gorosoft.bookme.now.android.NavGraphDestination
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    ProfileScreenContent(
        navigateToLanguageScreen = {
            navController.navigate(NavGraphDestination.ChooseLanguage.route)
        },
        navigateToEditProfileScreen = {
            navController.navigate(NavGraphDestination.EditProfile.route)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenContent(
    navigateToLanguageScreen: () -> Unit = {},
    navigateToEditProfileScreen: () -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState()
    val showCancelBookingDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .statusBarsPadding()
            .padding(start = 24.dp, end = 24.dp, top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Toolbar()
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            TopSection()
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(
                color = AppTheme.colors.grayscale.gs200,
                thickness = 1.dp,
            )
            Spacer(modifier = Modifier.height(24.dp))
            ProfileItems(
                onLanguageClick = navigateToLanguageScreen,
                onEditProfileClick = navigateToEditProfileScreen,
                onNotificationClick = { showCancelBookingDialog.value = true }
            )
        }
    }
    if (showCancelBookingDialog.value) {
        ModalBottomSheet(
            containerColor = AppTheme.colors.backgroundThemed.backgroundMain,
            onDismissRequest = {
                showCancelBookingDialog.value = false
            },
            sheetState = sheetState,
        ) {
            CancelBookingDialog(
                onCancel = { showCancelBookingDialog.value = false }
            )
        }
    }
}

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.profile),
            style = AppTheme.typography.heading.h4,
            color = AppTheme.colors.grayscale.gs900,
        )
        Image(
            painter = painterResource(R.drawable.ic_more),
            contentDescription = "More",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopSection(modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    val showLogoutBottomSheet = remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .padding(top = 34.dp)
            .debounceClick(onClick = { showLogoutBottomSheet.value = true })
    ) {
        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.barber_image_example),
            contentDescription = "User profile image"
        )
        Image(
            modifier = Modifier.align(Alignment.BottomEnd),
            painter = painterResource(R.drawable.ic_edit),
            contentDescription = "Edit profile image",
        )
    }
    Text(
        modifier = Modifier.padding(top = 12.dp),
        text = "John Doe",
        style = AppTheme.typography.heading.h4,
        color = AppTheme.colors.grayscale.gs900,
    )
    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = "tempmail@gmail.com",
        style = AppTheme.typography.bodyMedium.semibold,
        color = AppTheme.colors.grayscale.gs900,
    )
    if (showLogoutBottomSheet.value) {
        ModalBottomSheet(
            containerColor = AppTheme.colors.backgroundThemed.backgroundMain,
            onDismissRequest = {
                showLogoutBottomSheet.value = false
            },
            sheetState = sheetState,
        ) {
            LogoutBottomSheet(
                onCancel = { showLogoutBottomSheet.value = false }
            )
        }
    }
}

@Preview
@Composable
private fun ProfileScreenContentPreview() {
    AppTheme {
        ProfileScreenContent()
    }
}
