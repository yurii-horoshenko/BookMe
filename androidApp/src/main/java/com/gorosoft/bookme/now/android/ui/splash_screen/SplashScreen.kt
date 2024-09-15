package com.gorosoft.bookme.now.android.ui.splash_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gorosoft.bookme.now.android.NavGraphDestination
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

// TODO move to new SplashScreen API
@Suppress("MagicNumber")
@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashScreenViewModel = koinViewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = viewModel.effects) {
        viewModel.effects.collect {
            when (it) {
                is SplashScreenEffect.NavigateToLogin -> {
                    navController.popBackStack()
                    navController.navigate(NavGraphDestination.Login.route)
                }

                is SplashScreenEffect.NavigateToWelcome -> {
                    navController.popBackStack()
                    navController.navigate(NavGraphDestination.Welcome.route)
                }

                is SplashScreenEffect.NavigateToHome -> {
                    navController.popBackStack()
                    navController.navigate(NavGraphDestination.Main.route)
                }

                is SplashScreenEffect.ShowError -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.consumeEffect()
        }
    }
    SplashContent()
}

@Composable
private fun SplashContent() {
    Box(
        modifier = Modifier
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            text = stringResource(R.string.app_name),
            style = AppTheme.typography.heading.h1.copy(
                brush = Brush.horizontalGradient(AppTheme.colors.otherColors.orangeGradient),
                fontSize = 96.sp,
                fontWeight = FontWeight.Black
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashPreview() {
    AppTheme {
        SplashContent()
    }
}
