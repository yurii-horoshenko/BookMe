package com.gorosoft.bookme.now.android.ui.usecase

import com.gorosoft.bookme.now.android.ui_models.LanguageUiModel

class GetLanguagesUiUseCase {

    fun execute(): List<LanguageUiModel> {
        return listOf(
            LanguageUiModel(
                language = "English",
                languageCode = "en",
                selectedInitial = true
            ),
            LanguageUiModel(
                language = "Mandarin",
                languageCode = "zh"
            ),
            LanguageUiModel(
                language = "Hindi",
                languageCode = "hi"
            ),
            LanguageUiModel(
                language = "Spanish",
                languageCode = "es-ES"
            ),
            LanguageUiModel(
                language = "French",
                languageCode = "fr-FR"
            ),
            LanguageUiModel(
                language = "Arabic",
                languageCode = "ar-SA"
            ),
            LanguageUiModel(
                language = "Ukrainian",
                languageCode = "uk"
            ),
        )
    }
}
