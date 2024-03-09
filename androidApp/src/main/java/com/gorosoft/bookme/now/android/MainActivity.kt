package com.gorosoft.bookme.now.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gorosoft.bookme.now.android.ui.NavigationRoutes
import com.gorosoft.bookme.now.android.ui.SplashDirection
import com.gorosoft.bookme.now.android.ui.account_setup.LoginDirection
import com.gorosoft.bookme.now.android.ui.onboarding.TutorialCarouselDirection
import com.gorosoft.bookme.now.android.ui.onboarding.WelcomeDirection
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.LocalNavigator
import com.gorosoft.bookme.now.android.ui.utils.enableRealEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableRealEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(LocalNavigator provides navController) {
                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.Splash.route
                    ) {
                        composable(NavigationRoutes.Splash.route) {
                            SplashDirection(
                                navigateToWelcomeScreen = {
                                    navController.popBackStack()
                                    navController.navigate(NavigationRoutes.Welcome.route)
                                },
                            )
                        }
                        composable(NavigationRoutes.Welcome.route) {
                            WelcomeDirection(
                                navigateToTutorialCarousel = {
                                    navController.popBackStack()
                                    navController.navigate(NavigationRoutes.TutorialCarousel.route)
                                }
                            )
                        }
                        composable(NavigationRoutes.TutorialCarousel.route) {
                            TutorialCarouselDirection(
                                navigateToAccountSetup = {
                                    navController.popBackStack()
                                    navController.navigate(NavigationRoutes.Login.route)
                                }
                            )
                        }
                        composable(NavigationRoutes.Login.route) {
                            LoginDirection()
                        }
                    }
                }
            }
        }
    }
}
