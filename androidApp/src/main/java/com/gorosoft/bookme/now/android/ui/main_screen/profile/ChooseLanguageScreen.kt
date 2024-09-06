package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme


@Composable
fun ChooseLanguageScreen(
    modifier: Modifier = Modifier,
    onChoose: () -> Unit = { },
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(AppTheme.colors.backgroundThemed.backgroundMain),
        horizontalAlignment = Alignment.Start,
    ) {

        Text(
            modifier = Modifier
                .padding(top = 33.5.dp, start = 24.dp),
            text = stringResource(R.string.language),
            style = AppTheme.typography.heading.h4,
            color = AppTheme.colors.grayscale.gs900
        )


        Text(
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp),
            text = stringResource(R.string.suggested),
            style = AppTheme.typography.heading.h5,
            color = AppTheme.colors.grayscale.gs900
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.english_us),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio_selected),
                contentDescription = "Selected radio button image",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.english_uk),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .width(380.dp)
                .padding(top = 24.dp, start = 24.dp, end = 24.dp),
            color = AppTheme.colors.grayscale.gs200,
            thickness = 1.dp,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp),
                text = stringResource(R.string.changeLanguage),
                style = AppTheme.typography.heading.h4,
                color = AppTheme.colors.grayscale.gs900
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                //.padding(top = 24.dp, start = 24.dp),
                text = stringResource(R.string.mandarin),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.hindi),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.spanish),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.french),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.arabic),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.bengali),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.russian),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp, bottom = 40.dp)
                .clickable(onClick = onChoose),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.indonesia),
                style = AppTheme.typography.bodyXLarge.semibold,
                color = AppTheme.colors.grayscale.gs900
            )
            Image(
                modifier = Modifier.padding(end = 24.dp),
                painter = painterResource(R.drawable.ic_radio),
                contentDescription = "radio button image",
            )
        }
    }
}

@Preview
@Composable
private fun ChooseLanguageScreenPreview() {
    AppTheme {
        ChooseLanguageScreen()
    }
}
