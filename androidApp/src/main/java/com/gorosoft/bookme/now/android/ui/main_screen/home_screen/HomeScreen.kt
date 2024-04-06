package com.gorosoft.bookme.now.android.ui.main_screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.annotations.BottomBarNavGraph
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.SearchInput
import com.ramcosta.composedestinations.annotation.Destination
import java.time.LocalDateTime
import java.time.Month

@Suppress("MagicNumber")
@BottomBarNavGraph(start = true)
@Destination
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
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 34.dp),
                text = stringResource(R.string.app_name),
                style = AppTheme.typography.heading.h4,
                color = AppTheme.colors.grayscale.gs900,
            )
            Spacer(modifier = Modifier.height(24.dp))
            SearchInput(searchText = "")
            Spacer(modifier = Modifier.height(24.dp))
            NextVisitBadge(nexVisitDateTime = nextVisitTime)
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
