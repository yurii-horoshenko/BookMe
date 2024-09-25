package com.gorosoft.bookme.now.android.ui_models

import android.os.Parcelable
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class EditProfileUiModel(
    val firstName: String = "",
    val secondName: String = "",
    val email: String = "",
    val country: UserGenderType? = null,
    val gender: UserGenderType? = null,
    val phone: String = "",
    val dateOfBirthDate: LocalDate? = null,
    val address: String = "",
    ) : Parcelable {

    val dateOfBirthText get() = DateUtils.dateToString(dateOfBirthDate)
}