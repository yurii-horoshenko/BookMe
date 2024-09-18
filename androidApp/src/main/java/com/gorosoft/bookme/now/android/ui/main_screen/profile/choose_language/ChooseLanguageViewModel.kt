package com.gorosoft.bookme.now.android.ui.main_screen.profile.choose_language

import androidx.lifecycle.ViewModel
import com.gorosoft.bookme.now.android.ui.usecase.GetLanguagesUiUseCase
import com.gorosoft.bookme.now.android.ui_models.LanguageUiModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChooseLanguageViewModel(
    private val getLanguagesUiUseCase: GetLanguagesUiUseCase,
) : ViewModel() {

    private val _languagesFlow = MutableStateFlow(emptyList<LanguageUiModel>().toPersistentList())
    val languagesFlow = _languagesFlow.asStateFlow()

    init {
        _languagesFlow.update { getLanguagesUiUseCase.execute().toPersistentList() }
    }

    fun selectedLanguageChange(newSelectedLanguage: LanguageUiModel) {
        val selectedLanguage = _languagesFlow.value.find { it.isSelected }
        selectedLanguage?.let { selectedLanguage.isSelected = false }

        newSelectedLanguage.isSelected = true
    }
}
