package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

val LocalColors = staticCompositionLocalOf { lightColor }

val LocalTypography = staticCompositionLocalOf { typography }

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: AppTypography = AppTheme.typography,
    content: @Composable () -> Unit
) {
    val color = if (darkTheme) darkColor else lightColor
    val rippleIndication = remember { ripple() }
    CompositionLocalProvider(
        LocalColors provides color,
        LocalTypography provides typography,
        LocalIndication provides rippleIndication,
    ) {
        content.invoke()
    }
}
