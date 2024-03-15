package com.gorosoft.bookme.now.android.ui.utils

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun CancelButton(
    modifier: Modifier = Modifier,
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
            backgroundColor = AppTheme.colors.alertStatus.error.copy(alpha = 0.2f),
            disabledBackgroundColor = AppTheme.colors.alertStatus.disabledButton
        )
    ) {
        Text(
            text = stringResource(R.string.cancel),
            color = AppTheme.colors.alertStatus.error,
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
private fun CancelButtonPreview() {
    AppTheme {
        CancelButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            onClick = {}
        )
    }
}
