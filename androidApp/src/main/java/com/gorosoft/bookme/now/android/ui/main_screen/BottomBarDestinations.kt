package com.gorosoft.bookme.now.android.ui.main_screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gorosoft.bookme.now.android.R

enum class BottomBarDestinations(
    val route: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val notSelectedIcon: Int,
    @StringRes val label: Int,
) {
    Home(
        route = "home",
        selectedIcon = R.drawable.ic_home_selected,
        notSelectedIcon = R.drawable.ic_home_not_selected,
        label = R.string.home,
    ),
    Explore(
        route = "explore",
        selectedIcon = R.drawable.ic_explore_selected,
        notSelectedIcon = R.drawable.ic_explore_not_selected,
        label = R.string.explore,
    ),
    Profile(
        route = "profile",
        selectedIcon = R.drawable.ic_profile_selected,
        notSelectedIcon = R.drawable.ic_profile_not_selected,
        label = R.string.profile,
    )
}
