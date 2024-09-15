package com.gorosoft.bookme.now.android.ui.main_screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.SearchInput
import java.time.LocalDateTime
import java.time.Month

@Suppress("MagicNumber")
@Composable
fun HomeScreen() {
    HomeScreenContent(
        nextVisitTime = LocalDateTime.of(2024, Month.AUGUST, 30, 17, 30)
    )
}

@Composable
fun HomeScreenContent(
    nextVisitTime: LocalDateTime,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            contentPadding = PaddingValues(bottom = 24.dp),
        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(top = 34.dp)
                        .statusBarsPadding(),
                    text = stringResource(R.string.app_name),
                    style = AppTheme.typography.heading.h4,
                    color = AppTheme.colors.grayscale.gs900,
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { SearchInput(searchText = "") }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { NextVisitBanner(nexVisitDateTime = nextVisitTime) }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                ReminderBanner(
                    text = "Your route awaits!  Don't forget your \$100. " +
                            "Tap here to begin your journey today."
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = stringResource(R.string.nearby_your_location),
                    style = AppTheme.typography.heading.h5,
                    color = AppTheme.colors.grayscale.gs900,
                )
            }
            item {
                repeat(2) {
                    Spacer(modifier = Modifier.height(24.dp))
                    NearByLocationItem()
                }
            }
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Composable
private fun HomeScreenContentPreview() {
    AppTheme {
        HomeScreenContent(
            nextVisitTime = LocalDateTime.of(2024, Month.AUGUST, 30, 17, 30)
        )
    }
}
