package com.gorosoft.bookme.now.android.ui.main_screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick

@Composable
fun ReminderBanner(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(32.dp))
            .debounceClick(onClick = onClick)
            .background(brush = Brush.linearGradient(AppTheme.colors.otherColors.blueGradient))
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = text,
            style = AppTheme.typography.bodyXLarge.regular,
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun ReminderBannerPreview() {
    AppTheme {
        ReminderBanner(
            text = "Your route awaits!  Don't forget your \$100. " +
                    "Tap here to begin your journey today."
        )
    }
}
