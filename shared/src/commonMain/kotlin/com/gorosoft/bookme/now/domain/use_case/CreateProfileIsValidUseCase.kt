package com.gorosoft.bookme.now.domain.use_case

import com.gorosoft.bookme.now.domain.models.CreateProfileModel

class CreateProfileIsValidUseCase {

    fun execute(model: CreateProfileModel): Boolean {
        return model.gender != null &&
                model.fullName.isNullOrBlank().not() &&
                model.dayOfBirth != null &&
                model.monthOfBirth != null &&
                model.yearOfBirth != null
    }
}