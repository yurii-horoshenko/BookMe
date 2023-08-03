package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.gorosoft.bookme.now.android.R

internal val fontFamily = FontFamily(
    Font(
        resId = R.font.urbanist_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal,
    ),
    Font(
        resId = R.font.urbanist_semibold,
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal,
    ),
    Font(
        resId = R.font.urbanist_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal,
    ),
    Font(
        resId = R.font.urbanist_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal,
    ),
)

internal val typography = AppTypography(
    heading = Heading(),
)

data class AppTypography(
    val heading: Heading
)