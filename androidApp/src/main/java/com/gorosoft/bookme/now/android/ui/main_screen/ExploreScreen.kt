package com.gorosoft.bookme.now.android.ui.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.annotations.BottomBarNavGraph
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.ramcosta.composedestinations.annotation.Destination

@BottomBarNavGraph
@Destination
@Composable
fun ExploreScreen() {
    ExploreScreenContent()
}

@Composable
fun ExploreScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.explore)
        )
    }
}

@Preview
@Composable
private fun ExploreScreenContentPreview() {
    AppTheme {
        ExploreScreenContent()
    }
}
