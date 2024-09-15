package com.gorosoft.bookme.now.android.ui.account_setup

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.navigation.NavController
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.gorosoft.bookme.now.android.NavGraphDestination
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.account_setup.Effect.NavigateToHome
import com.gorosoft.bookme.now.android.ui.account_setup.Effect.ShowError
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.ButtonDefaultBottomPadding
import com.gorosoft.bookme.now.android.ui.utils.Loader
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = koinViewModel(),
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ShowError -> {
                    Toast.makeText(context, effect.message.getText(context), Toast.LENGTH_SHORT)
                        .show()
                }

                is NavigateToHome -> {
                    navController.navigate(NavGraphDestination.Main.route) {
                        popUpTo(NavGraphDestination.Login.route) {
                            inclusive = true
                        }
                    }
                }
            }
            viewModel.consumeEffect()
        }
    }

    LoginContent(
        showLoading = viewModel.showLoading.value,
        continueWithFacebook = {
            navController.navigate(NavGraphDestination.Main.route) {
                popUpTo(NavGraphDestination.Login.route) {
                    inclusive = true
                }
            }
        },
        continueWithGoogle = {
            viewModel.loginWithGoogle(it)
        },
        singInWithPhone = {
            navController.navigate(NavGraphDestination.CreateProfile.route)
        },
        showErrorMessage = {
            viewModel.showErrorMessage(it)
        }
    )
}

@Suppress("MagicNumber")
@Composable
fun LoginContent(
    showLoading: Boolean = false,
    continueWithFacebook: () -> Unit = {},
    continueWithGoogle: (Credential) -> Unit = {},
    singInWithPhone: () -> Unit = {},
    showErrorMessage: (String) -> Unit = {},
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
            SingInWithGoogle(
                continueWithGoogle = continueWithGoogle,
                showErrorMessage = showErrorMessage,
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
        if (showLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
                Loader(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Suppress("MagicNumber")
@Composable
private fun ContinueWithButton(
    modifier: Modifier = Modifier,
    @StringRes stringRes: Int,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit = {},
) {
    val shape = remember { RoundedCornerShape(16.dp) }
    Row(
        modifier = modifier
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

@Suppress("SwallowedException")
@Composable
private fun SingInWithGoogle(
    modifier: Modifier = Modifier,
    continueWithGoogle: (Credential) -> Unit = {},
    showErrorMessage: (String) -> Unit = {},
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val credentialManager = remember { CredentialManager.create(context) }
    ContinueWithButton(
        modifier = modifier,
        stringRes = R.string.continue_with_google,
        iconRes = R.drawable.ic_small_google,
        onClick = {
            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption
                .Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(context.getString(R.string.default_web_client_id))
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            coroutineScope.launch {
                try {
                    val result = credentialManager.getCredential(
                        request = request,
                        context = context,
                    )
                    continueWithGoogle(result.credential)
                } catch (e: GetCredentialException) {
                    showErrorMessage.invoke(context.getString(R.string.sorry_something_went_wrong))
                }
            }
        },
    )
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
        LoginContent(true)
    }
}
