package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick

@Suppress("LongMethod", "MagicNumber")
@Composable
fun ProfileScreenSettings(
    modifier: Modifier = Modifier,
    onLanguageClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(AppTheme.colors.backgroundThemed.backgroundMain),
        horizontalAlignment = Alignment.Start,
    ) {
        ProfileListItem(
            iconID = R.drawable.ic_profile,
            titleId = R.string.edit_profile,
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_notification,
            titleId = R.string.notification,
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_wallet,
            titleId = R.string.wallet,
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_security,
            titleId = R.string.security,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .debounceClick(onClick = onLanguageClick),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_language),
                contentDescription = "Language",
                modifier = Modifier.padding(end = 20.dp),
                colorFilter = ColorFilter.tint(AppTheme.colors.grayscale.gs900),
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
                .fillMaxWidth()
                .debounceClick { onLanguageClick },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_dark_mode),
                contentDescription = "Dark Mode",
                modifier = Modifier.padding(end = 20.dp),
                colorFilter = ColorFilter.tint(AppTheme.colors.grayscale.gs900),
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
                modifier = Modifier
                    .size(width = 40.dp, height = 24.dp)
                    .scale(0.7f),
                checked = false,
                thumbContent = {},
                onCheckedChange = {},
                colors = SwitchDefaults.colors(
                    checkedThumbColor = AppTheme.colors.grayscale.gs200,
                    checkedTrackColor = AppTheme.colors.mainColors.primary500,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = AppTheme.colors.grayscale.gs200,
                    uncheckedBorderColor = Color.Transparent,
                    checkedBorderColor = Color.Transparent,
                ),
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_privacy,
            titleId = R.string.privacy_policy,
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_invite_friends,
            titleId = R.string.invite_friends,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .debounceClick { onLanguageClick },
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

@Composable
private fun ProfileListItem(
    iconID: Int,
    titleId: Int,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .debounceClick { onClick },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(iconID),
            contentDescription = null,
            modifier = Modifier.padding(end = 20.dp),
            colorFilter = ColorFilter.tint(AppTheme.colors.grayscale.gs900),
        )
        Text(
            modifier = Modifier
                .padding(end = 40.dp)
                .weight(1f),
            text = stringResource(titleId),
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs900,
        )
        Image(
            painter = painterResource(R.drawable.ic_arrow_right),
            contentDescription = "Arrow",
        )
    }
}

@Preview
@Composable
fun ProfileScreenSettingsPreview() {
    ProfileScreenSettings()
}
