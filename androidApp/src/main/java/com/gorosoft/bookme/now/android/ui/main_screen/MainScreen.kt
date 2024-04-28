package com.gorosoft.bookme.now.android.ui.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gorosoft.bookme.now.android.ui.NavGraphs
import com.gorosoft.bookme.now.android.ui.appCurrentDestinationAsState
import com.gorosoft.bookme.now.android.ui.startAppDestination
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BottomNavigationShape
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.navigate

@Destination
@Composable
fun MainScreen() {
    MainScreenContent()
}

@Composable
private fun MainScreenContent() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
        DestinationsNavHost(
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
            navGraph = NavGraphs.bottomBar,
            navController = navController,
        )
    }
}

@Preview
@Composable
private fun MainScreenContentPreview() {
    AppTheme {
        MainScreenContent()
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val currentDestination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.bottomBar.startAppDestination
    BottomNavigation(
        modifier = modifier
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .navigationBarsPadding()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .border(
                width = 1.dp,
                color = AppTheme.colors.grayscale.gs200,
                shape = BottomNavigationShape(16.dp)
            ),
        backgroundColor = AppTheme.colors.backgroundThemed.backgroundMain,
    ) {
        BottomBarDestinations.entries.forEach {
            val isSelected = it.direction == currentDestination
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(it.direction) {
                        popUpTo(NavGraphs.bottomBar.startAppDestination.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    val iconRes = if (isSelected) it.selectedIcon else it.notSelectedIcon
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = stringResource(it.label) + "button image"
                    )
                },
                label = {
                    Text(
                        text = stringResource(it.label),
                        color = if (isSelected) {
                            AppTheme.colors.mainColors.primary500
                        } else {
                            AppTheme.colors.grayscale.gs500
                        },
                        style = AppTheme.typography.bodyXSmall.bold,
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    AppTheme {
        val navController = rememberNavController()
        BottomBar(navController = navController)
    }
}
