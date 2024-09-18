package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.SecondaryButton

@Composable
fun LogoutBottomSheet(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit = { },
    onCancel: () -> Unit = { },
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(R.string.logout),
            style = AppTheme.typography.heading.h4,
            color = AppTheme.colors.alertStatus.error

        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp),
            color = AppTheme.colors.grayscale.gs200,
            thickness = 1.dp,
        )
        Text(
            modifier = Modifier
                .padding(top = 24.dp),
            text = stringResource(R.string.are_you_sure_you_want_to_log_out),
            style = AppTheme.typography.heading.h5,
            color = AppTheme.colors.grayscale.gs800,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            SecondaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = stringResource(R.string.cancel),
                onClick = onCancel,
            )
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = stringResource(R.string.yes_logout),
                onClick = onLogout,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LogoutBottomSheetPreview() {
    AppTheme {
        LogoutBottomSheet()
    }
}
