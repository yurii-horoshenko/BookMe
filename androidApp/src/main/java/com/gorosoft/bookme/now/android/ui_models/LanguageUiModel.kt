package com.gorosoft.bookme.now.android.ui_models

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Stable
data class LanguageUiModel(
    val language: String,
    val languageCode: String,
    private val selectedInitial: Boolean = false
) {
    var isSelected by mutableStateOf(selectedInitial)
}
