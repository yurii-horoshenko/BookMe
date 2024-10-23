package com.gorosoft.bookme.now.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gorosoft.bookme.now.android.ui.account_setup.LoginScreen
import com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.CreateYourProfileScreen
import com.gorosoft.bookme.now.android.ui.account_setup.enter_otp.EnterOtpScreen
import com.gorosoft.bookme.now.android.ui.main_screen.MainScreen
import com.gorosoft.bookme.now.android.ui.main_screen.profile.EnableFeedbackDialog
import com.gorosoft.bookme.now.android.ui.main_screen.profile.FeedbackDialog
import com.gorosoft.bookme.now.android.ui.main_screen.profile.edit_profile.EditProfileScreen
import com.gorosoft.bookme.now.android.ui.main_screen.profile.choose_language.ChooseLanguageScreen
import com.gorosoft.bookme.now.android.ui.onboarding.TutorialCarouselScreen
import com.gorosoft.bookme.now.android.ui.onboarding.WelcomeScreen
import com.gorosoft.bookme.now.android.ui.splash_screen.SplashScreen
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.enableRealEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableRealEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavGraphDestination.Splash.route
                ) {
                    composable(NavGraphDestination.Splash.route) {
                        SplashScreen(navController = navController)
                    }
                    composable(NavGraphDestination.Welcome.route) {
                        WelcomeScreen(navController = navController)
                    }
                    composable(NavGraphDestination.Tutorial.route) {
                        TutorialCarouselScreen(navController = navController)
                    }
                    composable(NavGraphDestination.CreateProfile.route) {
                        CreateYourProfileScreen(navController = navController)
                    }
                    composable(
                        route = NavGraphDestination.EnterOtp.route,
                        arguments = listOf(
                            navArgument("phoneNumber") {
                                type = NavType.StringType
                                nullable = false
                            }
                        )
                    ) { backStackEntry ->
                        val phoneNumber = backStackEntry.arguments!!.getString("phoneNumber")!!
                        EnterOtpScreen(
                            navController = navController,
                            phoneNumber = phoneNumber,
                        )
                    }
                    composable(NavGraphDestination.Login.route) {
                        LoginScreen(navController = navController)
                    }
                    composable(NavGraphDestination.Main.route) {
                        MainScreen(navController = navController)
                    }
                    composable(NavGraphDestination.ChooseLanguage.route) {
                        ChooseLanguageScreen(navController = navController)
                    }
                    composable(NavGraphDestination.EditProfile.route) {
                        EditProfileScreen(navController = navController)
                    }
                    composable(NavGraphDestination.Wallet.route) {
                        EnableFeedbackDialog(navController = navController)
                    }
                }
            }
        }
    }
}
