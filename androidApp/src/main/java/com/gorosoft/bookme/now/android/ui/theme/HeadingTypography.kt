package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class HeadingTypography(
    val h1: TextStyle = TextStyle(
        fontSize = 48.sp,
        lineHeight = 52.8.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    val h2: TextStyle = TextStyle(
        fontSize = 40.sp,
        lineHeight = 44.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    val h3: TextStyle = TextStyle(
        fontSize = 32.sp,
        lineHeight = 35.2.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    val h4: TextStyle = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.8.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    val h5: TextStyle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    val h6: TextStyle = TextStyle(
        fontSize = 18.sp,
        lineHeight = 21.6.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
)
