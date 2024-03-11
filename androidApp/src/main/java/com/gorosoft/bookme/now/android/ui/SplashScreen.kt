package com.gorosoft.bookme.now.android.ui

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.destinations.WelcomeScreenDestination
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

// TODO move to new SplashScreen API
@Suppress("MagicNumber")
@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator,
) {
    LaunchedEffect(key1 = Unit) {
        // don't do this. It's just emulate the work
        delay(1000)
        navigator.popBackStack()
        navigator.navigate(WelcomeScreenDestination)
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
