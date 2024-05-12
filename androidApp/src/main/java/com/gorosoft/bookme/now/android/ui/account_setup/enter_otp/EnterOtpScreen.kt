package com.gorosoft.bookme.now.android.ui.account_setup.enter_otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.NavGraphs
import com.gorosoft.bookme.now.android.ui.destinations.MainScreenDestination
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BackButtonToolbar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun EnterOtpScreen(
    phoneNumber: String,
    navigator: DestinationsNavigator,
    viewModel: EnterOtpViewModel = koinViewModel()
) {
    val otpCode by viewModel.otpStateFlow.collectAsStateWithLifecycle()
    val resendOtpTime by viewModel.resendCodeFlow.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect {
            when (it) {
                EnterOtpEffects.ShowSuccessDialog -> {
                    navigator.navigate(MainScreenDestination) {
                        this.launchSingleTop = true
                        popUpTo(NavGraphs.root.route) { inclusive = true }
                    }
                }
            }
            viewModel.consumeEffect()
        }
    }

    EnterOtpContent(
        phoneNumber = phoneNumber,
        otpCode = otpCode,
        resendOtpTime = resendOtpTime,
        onOtpChanged = viewModel::updateOtp,
        navigateBack = { navigator.popBackStack() },
    )
}

@Composable
private fun EnterOtpContent(
    phoneNumber: String,
    otpCode: String,
    resendOtpTime: Int,
    onOtpChanged: (String) -> Unit = {},
    navigateBack: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .systemBarsPadding()
    ) {
        BackButtonToolbar(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 24.dp),
            title = R.string.enter_code,
            navigateBack = navigateBack,
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.code_sent_to, phoneNumber),
                style = AppTheme.typography.bodyXLarge.medium,
                textAlign = TextAlign.Center,
                color = AppTheme.colors.grayscale.gs900,
            )
            OtpInputField(
                modifier = Modifier.padding(top = 60.dp),
                text = otpCode,
                onValueChanged = onOtpChanged,
            )
            Text(
                text = buildAnnotatedString {
                    append(stringResource(R.string.resend_code))
                    append(" ")
                    withStyle(style = SpanStyle(color = AppTheme.colors.mainColors.primary500)) {
                        append(resendOtpTime.toString())
                    }
                    append(" ")
                    append(stringResource(R.string.seconds_of_resend_code))
                },
                modifier = Modifier.padding(top = 60.dp),
                color = AppTheme.colors.grayscale.gs900,
                style = AppTheme.typography.bodyXLarge.medium,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun EnterOptScreenPreview() {
    AppTheme {
        EnterOtpContent(
            phoneNumber = "+380 63 111 22 33",
            otpCode = "12",
            resendOtpTime = 13,
        )
    }
}
