@file:OptIn(ExperimentalFoundationApi::class)

package com.gorosoft.bookme.now.android.ui.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.ButtonDefaultBottomPadding
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.WormPageIndicator
import kotlinx.coroutines.launch

private const val TUTORIAL_PAGES_COUNT = 2

@Composable
fun TutorialCarouselDirection() {
//    val navController = LocalNavigator.current
//    navController.navigate("")
    TutorialCarouselScreen()
}

@Composable
private fun TutorialCarouselScreen(
    navigateToAccountSetup: () -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { TUTORIAL_PAGES_COUNT })
    val buttonTextRes = if (pagerState.currentPage == 0) {
        R.string.next
    } else {
        R.string.get_started
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .systemBarsPadding()
    ) {
        Column {
            Spacer(modifier = Modifier.fillMaxHeight(0.13f))
            HorizontalPager(
                modifier = Modifier.fillMaxHeight(0.7f),
                state = pagerState
            ) { page: Int ->
                when (page) {
                    0 -> {
                        TutorialPage(
                            stringRes = R.string.tutorial_text_1,
                            drawableRes = R.drawable.image_tutorial_1
                        )
                    }

                    1 -> {
                        TutorialPage(
                            stringRes = R.string.tutorial_text_2,
                            drawableRes = R.drawable.image_tutorial_2
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            WormPageIndicator(
                modifier = Modifier.fillMaxWidth(),
                currentPage = pagerState.currentPage,
                totalPages = TUTORIAL_PAGES_COUNT,
                indicatorSize = 8.dp,
                selectedMultiplier = 4
            )
        }

        PrimaryButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = ButtonDefaultBottomPadding),
            text = stringResource(buttonTextRes),
            shadowEnabled = false,
            onClick = {
                if (pagerState.currentPage == TUTORIAL_PAGES_COUNT - 1) {
                    navigateToAccountSetup.invoke()
                } else {
                    val nextPage = pagerState.currentPage + 1
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(nextPage)
                    }
                }
            })
    }
}

@Composable
private fun TutorialPage(
    @StringRes stringRes: Int,
    @DrawableRes drawableRes: Int,
) {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp),
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(drawableRes),
            contentDescription = "entertainment image #1",
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(stringRes),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.heading.h2
        )
    }
}

@Preview
@Composable
private fun TutorialCarouselScreenPreview() {
    AppTheme {
        TutorialCarouselScreen()
    }
}