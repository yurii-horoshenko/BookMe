package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

class BottomNavigationShape(
    private val cornerRadius: Dp,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        fun Dp.toPx(): Float = value * density.density

        return Outline.Generic(
            path = Path().apply {
                moveTo(0f, size.height)
                lineTo(0f, cornerRadius.toPx())
                cubicTo(
                    x1 = 0f,
                    y1 = cornerRadius.toPx() / 2,
                    x2 = cornerRadius.toPx() / 2,
                    y2 = 0f,
                    x3 = cornerRadius.toPx(),
                    y3 = 0f,
                )
                lineTo(size.width - cornerRadius.toPx(), 0f)
                cubicTo(
                    x1 = size.width - (cornerRadius.toPx() / 2),
                    y1 = 0f,
                    x2 = size.width,
                    y2 = cornerRadius.toPx() / 2,
                    x3 = size.width,
                    y3 = cornerRadius.toPx(),
                )
                lineTo(size.width, size.height)
            }
        )
    }
}
