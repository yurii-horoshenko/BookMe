package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class Heading(
    val heading1: TextStyle = TextStyle(
        fontSize = 48.sp,
        lineHeight = 52.8.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
    ),
)
