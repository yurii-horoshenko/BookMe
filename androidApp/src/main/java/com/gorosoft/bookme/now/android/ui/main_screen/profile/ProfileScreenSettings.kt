package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Preview
@Composable
fun ProfileScreenSettings(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(AppTheme.colors.backgroundThemed.backgroundMain),
        horizontalAlignment = Alignment.Start,

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "Profile",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = stringResource(R.string.edit_profile),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_notification),
                contentDescription = "Notification",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.notification)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_wallet),
                contentDescription = "Wallet",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.wallet)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_security),
                contentDescription = "Security",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.security)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_language),
                contentDescription = "Language",
                modifier = Modifier.padding(end = 20.dp),
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.language)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Text(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp,

                    ),
                text = (stringResource(R.string.english_us)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_dark_mode),
                contentDescription = "Dark Mode",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.dark_mode)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Switch(
                checked = false,
                onCheckedChange = {},
                colors = SwitchDefaults.colors(
                    checkedThumbColor = AppTheme.colors.grayscale.gs200,
                    checkedTrackColor = AppTheme.colors.mainColors.primary500,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = AppTheme.colors.grayscale.gs200,

                    ),
                
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_privacy),
                contentDescription = "Privacy Policy",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.privacy_policy)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_invite_friends),
                contentDescription = "Invite Friends",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.invite_friends)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900,
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Arrow",


                )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logout),
                contentDescription = "Logout",
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 40.dp)
                    .weight(1f),
                text = (stringResource(R.string.logout)),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.alertStatus.error,
            )
        }
    }
}


//@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ProfileScreenSettingsPreview() {


}
