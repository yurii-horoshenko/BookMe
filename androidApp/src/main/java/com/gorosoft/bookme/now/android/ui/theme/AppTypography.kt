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
    Font(
        resId = R.font.urbanist_black,
        weight = FontWeight.Black,
        style = FontStyle.Normal,
    )
)

internal val typography = AppTypography(
    heading = HeadingTypography(),
    bodyXLarge = BodyXLarge(),
    bodyLarge = BodyLarge(),
    bodyMedium = BodyMedium(),
    bodySmall = BodySmall(),
    bodyXSmall = BodyXSmall()
)

data class AppTypography(
    val heading: HeadingTypography,
    val bodyXLarge: BodyXLarge,
    val bodyLarge: BodyLarge,
    val bodyMedium: BodyMedium,
    val bodySmall: BodySmall,
    val bodyXSmall: BodyXSmall,
)