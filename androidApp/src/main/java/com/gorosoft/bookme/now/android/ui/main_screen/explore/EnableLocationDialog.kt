package com.gorosoft.bookme.now.android.ui.main_screen.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.SecondaryButton

@Composable
fun EnableLocationDialog(
    modifier: Modifier = Modifier,
    onEnableLocation: () -> Unit = { },
    onDismiss: () -> Unit = { },
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(AppTheme.colors.backgroundThemed.backgroundMain),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.padding(top = 40.dp),
                painter = painterResource(R.drawable.image_location_permission),
                contentDescription = "location permission image"
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(R.string.enable_location),
                style = AppTheme.typography.heading.h4,
                color = AppTheme.colors.mainColors.primary500,
            )
            Text(
                modifier = Modifier.padding(top = 16.dp, start = 32.dp, end = 32.dp),
                text = stringResource(R.string.enable_location_description),
                style = AppTheme.typography.bodyLarge.regular,
                color = AppTheme.colors.grayscale.gs900,
                textAlign = TextAlign.Center,
            )
            PrimaryButton(
                modifier = Modifier
                    .padding(top = 32.dp, start = 32.dp, end = 32.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.enable_location),
                onClick = onEnableLocation,
            )
            SecondaryButton(
                modifier = Modifier
                    .padding(top = 16.dp, start = 32.dp, end = 32.dp, bottom = 32.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.cancel),
                onClick = onDismiss,
            )
        }
    }
}

@Preview
@Composable
private fun EnableLocationDialogPreview() {
    AppTheme {
        EnableLocationDialog()
    }
}
