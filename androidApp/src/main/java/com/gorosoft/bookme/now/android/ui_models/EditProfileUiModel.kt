package com.gorosoft.bookme.now.android.ui_models

import android.os.Parcelable
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class EditProfileUiModel(
    val fullName: String = "",
    val gender: UserGenderType? = null,
    val dateOfBirthDate: LocalDate? = null,
) : Parcelable {

    val dateOfBirthText get() = DateUtils.dateToString(dateOfBirthDate)
}