package com.gorosoft.bookme.now.android.ui_models

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class CreateProfileUiModel(
    val fullName: String = "",
    val gender: UserGenderType? = null,
    val dateOfBirthDate: LocalDate? = null,
) : Parcelable {

    val dateOfBirthText get() = DateUtils.dateToString(dateOfBirthDate)
}

@Composable
fun UserGenderType.title(): String {
    return when (this) {
        UserGenderType.MALE -> stringResource(R.string.male_gender)
        UserGenderType.FEMALE -> stringResource(R.string.female_gender)
        UserGenderType.OTHER -> stringResource(R.string.other_gender)
    }
}
