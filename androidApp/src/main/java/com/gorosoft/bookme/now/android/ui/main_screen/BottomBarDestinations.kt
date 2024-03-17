package com.gorosoft.bookme.now.android.ui.main_screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.destinations.ExploreScreenDestination
import com.gorosoft.bookme.now.android.ui.destinations.HomeScreenDestination
import com.gorosoft.bookme.now.android.ui.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestinations(
    val direction: DirectionDestinationSpec,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val notSelectedIcon: Int,
    @StringRes val label: Int,
) {
    Home(
        direction = HomeScreenDestination,
        selectedIcon = R.drawable.ic_home_selected,
        notSelectedIcon = R.drawable.ic_home_not_selected,
        label = R.string.home,
    ),
    Explore(
        direction = ExploreScreenDestination,
        selectedIcon = R.drawable.ic_explore_selected,
        notSelectedIcon = R.drawable.ic_explore_not_selected,
        label = R.string.explore,
    ),
    Profile(
        direction = ProfileScreenDestination,
        selectedIcon = R.drawable.ic_profile_selected,
        notSelectedIcon = R.drawable.ic_profile_not_selected,
        label = R.string.profile,
    )
}
