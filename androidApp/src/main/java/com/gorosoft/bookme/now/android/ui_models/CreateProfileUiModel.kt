package com.gorosoft.bookme.now.android.ui_models

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import com.gorosoft.bookme.now.domain.models.UserGender
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

@Composable
fun UserGender.title(): String {
    return when (this) {
        UserGender.Male -> stringResource(R.string.male_gender)
        UserGender.Female -> stringResource(R.string.female_gender)
        UserGender.Other -> stringResource(R.string.other_gender)
    }
}
