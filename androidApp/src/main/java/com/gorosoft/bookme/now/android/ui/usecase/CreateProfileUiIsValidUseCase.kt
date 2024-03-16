package com.gorosoft.bookme.now.android.ui.usecase

import com.gorosoft.bookme.now.android.ui_models.CreateProfileUiModel
import javax.inject.Inject

class CreateProfileUiIsValidUseCase @Inject constructor() {

    fun execute(model: CreateProfileUiModel): Boolean {
        return model.gender != null &&
            model.fullName.isBlank().not() &&
            model.dateOfBirthDate != null
    }
}
