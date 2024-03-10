package com.gorosoft.bookme.now.android.ui.utils

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shadowEnabled: Boolean = false
) {
    if (shadowEnabled) {
        val shadowModifier = if (enabled) {
            Modifier.shadow(
                elevation = 10.dp,
                shape = CircleShape,
                ambientColor = AppTheme.colors.mainColors.primary500.copy(alpha = 1f),
                spotColor = AppTheme.colors.mainColors.primary500.copy(alpha = 1f)
            )
        } else {
            Modifier
        }
        BoxWithConstraints(
            modifier = Modifier
                .wrapContentHeight()
                .padding(bottom = 20.dp)
        ) {
            PrimaryButtonInternal(
                modifier = modifier,
                text = text,
                onClick = onClick,
                enabled = enabled
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = ButtonHeight / 2)
                    .fillMaxWidth()
                    .height(38.dp)
                    .then(shadowModifier)
            )
        }
    } else {
        PrimaryButtonInternal(
            modifier = modifier,
            text = text,
            onClick = onClick,
            enabled = enabled
        )
    }
}

@Composable
private fun PrimaryButtonInternal(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    val debouncer = remember { ClickDebouncer() }
    Button(
        modifier = modifier.height(ButtonHeight),
        onClick = { debouncer.processClick(onClick) },
        enabled = enabled,
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTheme.colors.mainColors.primary500,
            disabledBackgroundColor = AppTheme.colors.alertStatus.disabledButton
        )
    ) {
        Text(
            text = text,
            color = Color.White,
            style = AppTheme.typography.bodyLarge.bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun PrimaryButtonPreview() {
    AppTheme {
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            shadowEnabled = true,
            text = "Some text",
            enabled = true,
            onClick = {}
        )
    }
}
