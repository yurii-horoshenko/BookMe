package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.SecondaryButton

@Composable
fun CancelBookingDialog(
    modifier: Modifier = Modifier,
    onCancelBooking: () -> Unit = { },
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
            text = stringResource(R.string.cancel_booking),
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
            text = (
                    "Are you sure want to cancel your\n" +
                    "barber/salon booking?"
                    ),
            style = AppTheme.typography.heading.h5,
            color = AppTheme.colors.grayscale.gs800,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = ("Only 80% of the money you can refund from\n" +
                    "your payment according to our policy"),
            style = AppTheme.typography.bodyMedium.medium,//змінити стиль
            color = AppTheme.colors.grayscale.gs800,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),

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
                text = (stringResource(R.string.yes_cancel_booking)),
                onClick = onCancelBooking,
            )
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun CancelBookingDialogPreview(){
CancelBookingDialog()
}
