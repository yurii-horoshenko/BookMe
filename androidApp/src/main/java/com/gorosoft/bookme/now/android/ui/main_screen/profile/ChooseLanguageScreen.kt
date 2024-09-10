package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick


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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp)
                .clickable(onClick = onChoose),
        ) {
            Image(
                modifier = Modifier.padding(),
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "back arrow",
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = stringResource(R.string.language),
                style = AppTheme.typography.heading.h4,
                color = AppTheme.colors.grayscale.gs900
            )
        }

        Text(
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp),
            text = stringResource(R.string.suggested),
            style = AppTheme.typography.heading.h5,
            color = AppTheme.colors.grayscale.gs900
        )

        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.english_us
        )

        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.english_uk
       )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
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

        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.mandarin
        )
        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.hindi
        )
        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.spanish
        )

        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.french
        )

        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.arabic
        )
        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.bengali
        )

        Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.russian
        )
  Spacer(modifier = Modifier.height(24.dp))
        ChooseLanguageItem(
            languaheId = R.string.indonesia
        )

    }
}

@Composable
private fun ChooseLanguageItem(
    languaheId: Int,
) {
    var selectedOption by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp,end = 10.dp)
            .debounceClick { selectedOption = !selectedOption },
        //horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(languaheId),
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs900
        )
        RadioButton(
            modifier = Modifier,
            selected = selectedOption,
            onClick = { selectedOption = !selectedOption },
            colors = RadioButtonDefaults.colors(
                selectedColor = AppTheme.colors.mainColors.primary500,
                unselectedColor =  AppTheme.colors.mainColors.primary500,
                disabledColor =  AppTheme.colors.mainColors.primary500,
            )
        )
    }
}

@Preview
@Composable
private fun ChooseLanguageScreenPreview() {
    AppTheme {
        ChooseLanguageScreen()
    }
}
