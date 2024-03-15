package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun TextFieldDefaults.appThemeTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = AppTheme.colors.grayscale.gs900,
        backgroundColor = AppTheme.colors.grayscale.gs50,
        cursorColor = AppTheme.colors.mainColors.primary500,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        disabledTextColor = AppTheme.colors.grayscale.gs900,
    )
}
