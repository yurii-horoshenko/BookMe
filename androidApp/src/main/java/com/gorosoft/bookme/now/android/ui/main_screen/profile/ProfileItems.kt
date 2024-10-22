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
fun ProfileItems(
    modifier: Modifier = Modifier,
    onLanguageClick: () -> Unit = {},
    onEditProfileClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onWalletClick: () -> Unit = {},
    onSecurityClick: () -> Unit = {},
    onDarkModeClick: () -> Unit = {},
    onPrivacyPolicyClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
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
            modifier = Modifier.debounceClick(onClick = onEditProfileClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_notification,
            titleId = R.string.notification,
            modifier = Modifier.debounceClick(onClick = onNotificationClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_wallet,
            titleId = R.string.wallet,
            modifier = Modifier.debounceClick(onClick = onWalletClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_security,
            titleId = R.string.security,
            modifier = Modifier.debounceClick(onClick = onSecurityClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        LanguageItem(
            iconID = R.drawable.ic_language,
            titleId = R.string.language,
            languageId = R.string.english_us,
            modifier = Modifier.debounceClick(onClick = onLanguageClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        DarkModeItem(
            iconID = R.drawable.ic_dark_mode,
            titleId = R.string.dark_mode,
            modifier = Modifier.debounceClick(onClick = onDarkModeClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_privacy,
            titleId = R.string.privacy_policy,
            modifier = Modifier.debounceClick(onClick = onPrivacyPolicyClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileListItem(
            iconID = R.drawable.ic_invite_friends,
            titleId = R.string.invite_friends,
            modifier = Modifier.debounceClick(onClick = onNotificationClick),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .debounceClick(onClick = onLogoutClick),
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
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun ProfileListItem(
    modifier: Modifier = Modifier,
    iconID: Int,
    titleId: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
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

@Composable
fun LanguageItem(
    modifier: Modifier = Modifier,
    iconID: Int,
    titleId: Int,
    languageId: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(iconID),
            contentDescription = "Language",
            modifier = Modifier.padding(end = 20.dp),
            colorFilter = ColorFilter.tint(AppTheme.colors.grayscale.gs900),
        )
        Text(
            modifier = Modifier
                .padding(end = 40.dp)
                .weight(1f),
            text = (stringResource(titleId)),
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs900,
        )
        Text(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
            ),
            text = (stringResource(languageId)),
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs900,
        )
        Image(
            painter = painterResource(R.drawable.ic_arrow_right),
            contentDescription = "Arrow",
        )
    }
}

@Suppress("MagicNumber")
@Composable
fun DarkModeItem(
    modifier: Modifier = Modifier,
    iconID: Int,
    titleId: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(iconID),
            contentDescription = "Dark Mode",
            modifier = Modifier.padding(end = 20.dp),
            colorFilter = ColorFilter.tint(AppTheme.colors.grayscale.gs900),
        )
        Text(
            modifier = Modifier
                .padding(end = 40.dp)
                .weight(1f),
            text = (stringResource(titleId)),
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
}

@Preview
@Composable
fun ProfileItemsPreview() {
    ProfileItems()
}
