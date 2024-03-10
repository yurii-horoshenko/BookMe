package com.gorosoft.bookme.now.android.ui

sealed class NavigationRoutes(val route: String) {
    data object Splash : NavigationRoutes("splash")

    data object Welcome : NavigationRoutes("welcome")

    data object TutorialCarousel : NavigationRoutes("tutorial_carousel")
}
