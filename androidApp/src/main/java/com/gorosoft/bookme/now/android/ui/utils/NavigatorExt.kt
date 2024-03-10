package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController

val LocalNavigator = compositionLocalOf<NavController> {
    error("no local navigator")
}
