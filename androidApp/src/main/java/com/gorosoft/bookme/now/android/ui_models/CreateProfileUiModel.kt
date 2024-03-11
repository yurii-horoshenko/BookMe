package com.gorosoft.bookme.now.android.ui_models

import android.os.Parcelable
import androidx.annotation.StringRes
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class CreateProfileUiModel(
    val fullName: String = "",
    val gender: UserGender? = null,
    val dateOfBirthDate: LocalDate? = null,
) : Parcelable {

    val dateOfBirthText get() = DateUtils.dateToString(dateOfBirthDate)
}

enum class UserGender(@StringRes val titleRes: Int) {
    Male(R.string.male_gender),
    Female(R.string.female_gender),
    Other(R.string.other_gender)
}
