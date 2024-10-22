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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gorosoft.bookme.now.android.ui.main_screen.explore.ExploreScreen
import com.gorosoft.bookme.now.android.ui.main_screen.home.HomeScreen
import com.gorosoft.bookme.now.android.ui.main_screen.profile.ProfileScreen
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BottomNavigationShape

@Composable
fun MainScreen(navController: NavController) {
    MainScreenContent(navController = navController)
}

@Composable
private fun MainScreenContent(navController: NavController = rememberNavController()) {
    val bottomBarNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = bottomBarNavController,
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
            navController = bottomBarNavController,
            startDestination = BottomBarDestinations.Home.route,
        ) {
            composable(route = BottomBarDestinations.Home.route) {
                HomeScreen()
            }
            composable(route = BottomBarDestinations.Explore.route) {
                ExploreScreen(navController = navController)
            }
            composable(route = BottomBarDestinations.Profile.route) {
                ProfileScreen(navController = navController)
            }
        }
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
    navController: NavController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
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
            val isSelected = it.route == currentDestination?.route
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(BottomBarDestinations.Home.route) {
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
        BottomBar(
            navController = navController,
        )
    }
}
