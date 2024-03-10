package com.gorosoft.bookme.now.android.ui.account_setup

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.ButtonDefaultBottomPadding
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun LoginScreen() {
    LoginContent(
//        continueWithFacebook = continueWithFacebook,
//        continueWithGoogle = continueWithGoogle,
//        singInWithPhone = singInWithPhone,
    )
}

@Suppress("MagicNumber")
@Composable
fun LoginContent(
    continueWithFacebook: () -> Unit = {},
    continueWithGoogle: () -> Unit = {},
    singInWithPhone: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .systemBarsPadding()
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.fillMaxHeight(0.13f))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.image_account_setup),
                contentDescription = "abstract image",
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.07f))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.lets_you_in),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.heading.h1,
                color = AppTheme.colors.grayscale.gs900,
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = ButtonDefaultBottomPadding)

        ) {
            ContinueWithButton(
                stringRes = R.string.continue_with_facebook,
                iconRes = R.drawable.ic_small_facebook,
                onClick = continueWithFacebook
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContinueWithButton(
                stringRes = R.string.continue_with_google,
                iconRes = R.drawable.ic_small_google,
                onClick = continueWithGoogle,
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomDivider()
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.login_button_text),
                onClick = singInWithPhone,
            )
        }
    }
}

@Suppress("MagicNumber")
@Composable
private fun ContinueWithButton(
    @StringRes stringRes: Int,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit = {},
) {
    val shape = remember { RoundedCornerShape(16.dp) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 1.dp,
                color = AppTheme.colors.grayscale.gs200,
                shape = shape
            )
            .clip(shape)
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .debounceClick(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(iconRes),
            contentDescription = "social media company image",
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(stringRes),
            style = AppTheme.typography.bodyLarge.semibold
        )
    }
}

@Suppress("MagicNumber")
@Composable
private fun CustomDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Divider(
            modifier = Modifier
                .weight(0.4f)
                .padding(start = 10.dp),
            color = AppTheme.colors.grayscale.gs200
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "or",
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs700
        )
        Divider(
            modifier = Modifier
                .weight(0.4f)
                .padding(end = 10.dp),
            color = AppTheme.colors.grayscale.gs200
        )
    }
}

@Preview(showBackground = false, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ContinueWithButtonPreview() {
    AppTheme {
        ContinueWithButton(
            stringRes = R.string.continue_with_facebook,
            iconRes = R.drawable.ic_small_facebook,
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    AppTheme {
        LoginContent()
    }
}
