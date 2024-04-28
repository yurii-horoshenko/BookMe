@file:Suppress("MagicNumber")

package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.ui.graphics.Color

internal val lightColor = AppColors(
    backgroundThemed = BackgroundThemed(
        backgroundMain = Color(0xFFFFFFFF),
        backgroundSecondary = Color(0xFFFAFAFA),
        backgroundTertiary = Color(0xFFEEEEEE)
    ),
    isLight = true
)

internal val darkColor = AppColors(
    backgroundThemed = BackgroundThemed(
        backgroundMain = Color(0xFF181A20),
        backgroundSecondary = Color(0xFF1F222A),
        backgroundTertiary = Color(0xFF35383F)
    ),
    isLight = false
)

data class AppColors(
    val mainColors: MainColors = MainColors(),
    val alertStatus: AlertStatus = AlertStatus(),
    val grayscale: Grayscale = Grayscale(),
    val otherColors: OtherColors = OtherColors(),
    val backgroundThemed: BackgroundThemed,
    val isLight: Boolean
)

data class MainColors(
    val primary500: Color = Color(0xFFFB9400),
    val primary400: Color = Color(0xFFFCA933),
    val primary300: Color = Color(0xFFFDBF66),
    val primary200: Color = Color(0xFFFDD499),
    val primary100: Color = Color(0xFFFFF4E6),
    val secondary500: Color = Color(0xFFFFD300),
    val secondary400: Color = Color(0xFFFFDC33),
    val secondary300: Color = Color(0xFFFFE566),
    val secondary200: Color = Color(0xFFFFED99),
    val secondary100: Color = Color(0xFFFFFBE6)
)

data class AlertStatus(
    val success: Color = Color(0xFF4ADE80),
    val info: Color = Color(0xFF246BFD),
    val warning: Color = Color(0xFFFACC15),
    val error: Color = Color(0xFFF75555),
    val disabled: Color = Color(0xFFD8D8D8),
    val disabledButton: Color = Color(0xFFE9A33F)
)

data class BackgroundThemed(
    val backgroundMain: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color
)

data class Grayscale(
    val gs900: Color = Color(0xFF212121),
    val gs800: Color = Color(0xFF424242),
    val gs700: Color = Color(0xFF616161),
    val gs600: Color = Color(0xFF757575),
    val gs500: Color = Color(0xFF9E9E9E),
    val gs400: Color = Color(0xFFBDBDBD),
    val gs300: Color = Color(0xFFE0E0E0),
    val gs200: Color = Color(0xFFEEEEEE),
    val gs100: Color = Color(0xFFF5F5F5),
    val gs50: Color = Color(0xFFFAFAFA)
)

data class OtherColors(
    val orangeGradient: List<Color> = listOf(Color(0xFFFFAB38), Color(0xFFFB9400)),
    val blueGradient: List<Color> = listOf(Color(0xFF6F9EFF), Color(0xFF246BFD))
)
