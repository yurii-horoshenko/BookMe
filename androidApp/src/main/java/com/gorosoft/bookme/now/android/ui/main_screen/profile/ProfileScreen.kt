package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.annotations.BottomBarNavGraph
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@BottomBarNavGraph
@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
) {
    ProfileScreenContent()
}

@Composable
fun ProfileScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .statusBarsPadding()
            .padding(start = 24.dp, end = 24.dp, top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Toolbar()
        Spacer(modifier = Modifier.height(24.dp))
        TopSection()
        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider(
            color = AppTheme.colors.grayscale.gs200,
            thickness = 1.dp,
        )
    }
}

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.profile),
            style = AppTheme.typography.heading.h4,
            color = AppTheme.colors.grayscale.gs900,
        )
        Image(
            painter = painterResource(R.drawable.ic_more),
            contentDescription = "More",
        )
    }
}

@Composable
private fun TopSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(top = 34.dp)
            .debounceClick(onClick = {})
    ) {
        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.barber_image_example),
            contentDescription = "User profile image"
        )
        Image(
            modifier = Modifier.align(Alignment.BottomEnd),
            painter = painterResource(R.drawable.ic_edit),
            contentDescription = "Edit profile image",
        )
    }
    Text(
        modifier = Modifier.padding(top = 12.dp),
        text = "John Doe",
        style = AppTheme.typography.heading.h4,
        color = AppTheme.colors.grayscale.gs900,
    )
    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = "tempmail@gmail.com",
        style = AppTheme.typography.bodyMedium.semibold,
        color = AppTheme.colors.grayscale.gs900,
    )
}

@Preview
@Composable
private fun ProfileScreenContentPreview() {
    AppTheme {
        ProfileScreenContent()
    }
}
