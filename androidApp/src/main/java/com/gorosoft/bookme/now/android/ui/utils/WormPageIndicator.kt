package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun WormPageIndicator(
    totalPages: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    indicatorSize: Dp = 6.dp,
    spacing: Dp = indicatorSize,
    selectedMultiplier: Int = 3
) {
    assert(
        value = currentPage in 0 until totalPages,
        lazyMessage = { "Current page index is out of range." }
    )
    val activeColor = AppTheme.colors.mainColors.primary500
    val nonActiveColor = AppTheme.colors.grayscale.gs300
    val rowWidth = remember {
        (indicatorSize * (selectedMultiplier + (totalPages - 1))) + (spacing * (totalPages - 1))
    }
    Row(
        modifier = modifier.requiredWidth(rowWidth),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(totalPages) { iteration ->
            val selected = iteration == currentPage
            val width: Dp by animateDpAsState(
                if (selected) indicatorSize * selectedMultiplier else indicatorSize,
                label = "DpAnimation"
            )
            val color = if(selected) activeColor else nonActiveColor
            Canvas(
                modifier = Modifier.size(width, indicatorSize),
                onDraw = {
                    drawRoundRect(
                        color = color,
                        cornerRadius = CornerRadius(indicatorSize.toPx() / 2),
                        size = Size(width.toPx(), indicatorSize.toPx())
                    )
                }
            )
        }
    }
}