package com.gorosoft.bookme.now.android.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun WelcomeDirection(
    navigateToTutorialCarousel: () -> Unit = {},
) {
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        navigateToTutorialCarousel.invoke()
    }
    WelcomeScreen()
}

@Composable
private fun WelcomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.image_welcome),
            contentDescription = "welcome image"
        )
        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = 12.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.welcome),
                style = AppTheme.typography.heading.h1,
                color = Color.White,
            )
            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = stringResource(R.string.app_name),
                style = AppTheme.typography.heading.h1.copy(
                    brush = Brush.horizontalGradient(AppTheme.colors.otherColors.orangeGradient),
                    fontSize = 96.sp,
                    fontWeight = FontWeight.Black,
                ),
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = stringResource(R.string.welcome_description),
                style = AppTheme.typography.bodyXLarge.medium,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun WelcomePreview() {
    AppTheme {
        WelcomeScreen()
    }
}