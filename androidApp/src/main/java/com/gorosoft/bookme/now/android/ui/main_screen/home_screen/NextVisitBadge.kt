package com.gorosoft.bookme.now.android.ui.main_screen.home_screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import java.time.LocalDateTime
import java.time.Month

@Composable
fun NextVisitBadge(
    modifier: Modifier = Modifier,
    nexVisitDateTime: LocalDateTime
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                brush = Brush.linearGradient(
                    colors = AppTheme.colors.otherColors.orangeGradient,
                ),
                shape = RoundedCornerShape(32.dp),
            )
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "Your next visit",
                    style = AppTheme.typography.heading.h4,
                    color = Color.White,
                )
                Text(
                    text = "Bell Curls",
                    style = AppTheme.typography.bodyLarge.semibold,
                    color = Color.White,
                )
                Text(
                    text = "0993, NY, Novick Parkway 45",
                    style = AppTheme.typography.bodyLarge.semibold,
                    color = Color.White,
                )
            }
            CalendarItem(nexVisitDateTime)
        }
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Chip(
                onClick = { },
                backgroundColor = AppTheme.colors.alertStatus.info,
                textAndImageColor = Color.White,
                title = R.string.call,
                imageRes = R.drawable.ic_calling,
            )
            Chip(
                onClick = { },
                backgroundColor = AppTheme.colors.alertStatus.error,
                textAndImageColor = Color.White,
                title = R.string.cancel,
                imageRes = R.drawable.ic_delete,
            )
            Chip(
                onClick = { },
                backgroundColor = Color.White,
                textAndImageColor = AppTheme.colors.mainColors.primary500,
                title = R.string.map,
                imageRes = R.drawable.ic_location,
            )
        }
    }
}

@Composable
private fun CalendarItem(
    date: LocalDateTime,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .size(77.dp)
            .background(AppTheme.colors.backgroundThemed.backgroundMain),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = date.dayOfWeek.name,
            style = AppTheme.typography.bodyLarge.semibold,
            color = AppTheme.colors.alertStatus.error,
            maxLines = 1,
        )
        Text(
            text = date.dayOfMonth.toString(),
            style = AppTheme.typography.heading.h4,
            color = AppTheme.colors.grayscale.gs900,
        )
        Text(
            text = "${date.hour}:${date.minute}",
            style = AppTheme.typography.bodyMedium.medium,
            color = AppTheme.colors.grayscale.gs900,
        )
    }
}

@Composable
private fun Chip(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    backgroundColor: Color,
    textAndImageColor: Color,
    @StringRes title: Int,
    @DrawableRes imageRes: Int,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(CornerSize(percent = 50)))
            .debounceClick(onClick = onClick)
            .background(backgroundColor)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            colorFilter = ColorFilter.tint(textAndImageColor)
        )
        Text(
            text = stringResource(title),
            style = AppTheme.typography.bodyLarge.semibold,
            color = textAndImageColor,
            maxLines = 1,
        )
    }
}

@Suppress("MagicNumber")
@Preview
@Composable
private fun CalendarItemPreview() {
    AppTheme {
        CalendarItem(date = LocalDateTime.of(2024, Month.AUGUST, 30, 17, 30))
    }
}

@Suppress("MagicNumber")
@Preview
@Composable
private fun NextVisitBadgePreview() {
    AppTheme {
        NextVisitBadge(nexVisitDateTime = LocalDateTime.of(2024, Month.AUGUST, 30, 17, 30))
    }
}
