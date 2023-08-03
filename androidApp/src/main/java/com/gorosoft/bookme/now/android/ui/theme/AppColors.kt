package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.ui.graphics.Color

internal val lightColor = AppColors(
    backgroundThemed = BackgroundThemed(
        backgroundMain = Color(0xFFFFFFFF),
        backgroundSecondary = Color(0xFFFAFAFA),
        backgroundTertiary = Color(0xFFEEEEEE),
    ),
    isLight = true,
)

internal val darkColor = AppColors(
    backgroundThemed = BackgroundThemed(
        backgroundMain = Color(0xFF181A20),
        backgroundSecondary = Color(0xFF1F222A),
        backgroundTertiary = Color(0xFF35383F),
    ),
    isLight = false,
)

data class AppColors(
    val mainColors: MainColors = MainColors(),
    val alertStatus: AlertStatus = AlertStatus(),
    val backgroundThemed: BackgroundThemed,
    val isLight: Boolean,
)

data class MainColors(
    val primary500: Color = Color(0xFFFB9400),
    val primary400: Color = Color(0xFFFCA933),


    val secondary500: Color = Color(0xFFFFD300),
    val secondary400: Color = Color(0xFFFFDC33),
)

data class AlertStatus(
    val success: Color = Color(0xFF4ADE80),
    val info: Color = Color(0xFF246BFD),
    val warning: Color = Color(0xFFFACC15),
    val error: Color = Color(0xFFF75555),
)

data class BackgroundThemed(
    val backgroundMain: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
)