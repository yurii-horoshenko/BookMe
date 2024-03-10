package com.gorosoft.bookme.now.android.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentColor
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
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

@Immutable
private object AppRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = LocalContentColor.current,
        lightTheme = AppTheme.colors.isLight
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = LocalContentColor.current,
        lightTheme = AppTheme.colors.isLight
    )
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: AppTypography = AppTheme.typography,
    content: @Composable () -> Unit
) {
    val color = if (darkTheme) darkColor else lightColor
    val rippleIndication = rememberRipple()
    CompositionLocalProvider(
        LocalColors provides color,
        LocalTypography provides typography,
        LocalIndication provides rippleIndication,
        LocalRippleTheme provides AppRippleTheme
    ) {
        content.invoke()
    }
}
