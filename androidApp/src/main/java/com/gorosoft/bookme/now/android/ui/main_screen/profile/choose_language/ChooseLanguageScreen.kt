package com.gorosoft.bookme.now.android.ui.main_screen.profile.choose_language

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BackButtonToolbar
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
        onSelectionChanged = viewModel::selectedLanguageChange
    )
}

@Suppress("UnusedParameter")
@Composable
private fun ChooseLanguageContent(
    languages: PersistentList<LanguageUiModel>,
    modifier: Modifier = Modifier,
    onSelectionChanged: (LanguageUiModel) -> Unit = {},
    onNavigateBack: () -> Unit = { },
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .statusBarsPadding()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        BackButtonToolbar(
            modifier = Modifier.padding(start = 24.dp),
            title = R.string.language,
            navigateBack = onNavigateBack,
        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn {
            items(languages) { language ->
                ChooseLanguageItem(
                    language = language.language,
                    isSelected = language.isSelected,
                    onSelectionChanged = {
                        onSelectionChanged(language)
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
            .debounceClick { onSelectionChanged() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = language,
            style = AppTheme.typography.bodyXLarge.semibold,
            color = AppTheme.colors.grayscale.gs900
        )
        RadioButton(
            modifier = Modifier,
            selected = isSelected,
            onClick = onSelectionChanged,
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
            languages = listOf(
                LanguageUiModel(
                    language = "English",
                    languageCode = "en",
                    selectedInitial = true
                ),
                LanguageUiModel(
                    language = "English",
                    languageCode = "en",
                    selectedInitial = true
                ),
                LanguageUiModel(
                    language = "English",
                    languageCode = "en",
                    selectedInitial = true
                ),
            ).toPersistentList()
        )
    }
}
