package com.gorosoft.bookme.now.android.ui.main_screen.profile.choose_language

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.gorosoft.bookme.now.android.ui_models.LanguageUiModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChooseLanguageScreen(
    navController: NavController,
    viewModel: ChooseLanguageViewModel = koinViewModel(),
) {
    val languages by viewModel.languagesFlow.collectAsStateWithLifecycle()
    ChooseLanguageContent(
        languages = languages,
        onNavigateBack = navController::popBackStack,
    )
}

@Suppress("UnusedParameter")
@Composable
private fun ChooseLanguageContent(
    languages: PersistentList<LanguageUiModel>,
    modifier: Modifier = Modifier,
    onChoose: () -> Unit = { },
    onNavigateBack: () -> Unit = { },
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(AppTheme.colors.backgroundThemed.backgroundMain),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 54.dp, start = 24.dp),
        ) {
            Image(
                modifier = Modifier
                    .padding()
                    .debounceClick(onClick = onNavigateBack),
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

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(languages) { language ->
                ChooseLanguageItem(
                    language = language.language,
                    isSelected = language.isSelected,
                    onSelectionChanged = {
                        selectedLanguageChange(language, languages)
                    },
                    modifier = Modifier
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
private fun ChooseLanguageItem(
    language: String,
    isSelected: Boolean,
    onSelectionChanged: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 27.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .debounceClick {onSelectionChanged() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = language,
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs900
        )
        RadioButton(
            modifier = Modifier.size(20.dp),
            selected = isSelected,
            onClick =  onSelectionChanged,
            colors = RadioButtonDefaults.colors(
                selectedColor = AppTheme.colors.mainColors.primary500,
                unselectedColor = AppTheme.colors.mainColors.primary500,
                disabledColor = AppTheme.colors.mainColors.primary500,
            )
        )
    }
}

@Preview
@Composable
private fun ChooseLanguageScreenPreview() {
    AppTheme {
        ChooseLanguageContent(
            languages = emptyList<LanguageUiModel>().toPersistentList()
        )
    }
}
