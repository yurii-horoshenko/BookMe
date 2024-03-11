package com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gorosoft.bookme.now.android.ui_models.CreateProfileUiModel
import com.gorosoft.bookme.now.android.ui_models.UserGender
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

private const val ProfileKey = "CreateYourProfile"

@HiltViewModel
class CreateYourProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val state get() = profileState.value

    val profileState = savedStateHandle.getStateFlow(ProfileKey, CreateProfileUiModel())

    fun updateName(newFullName: String) {
        updateState { copy(fullName = newFullName) }
    }

    fun updateGender(gender: UserGender) {
        updateState { copy(gender = gender) }
    }

    fun updateDateOfBirth(date: LocalDate) {
        updateState { copy(dateOfBirthDate = date) }
    }

    private fun updateState(action: CreateProfileUiModel.() -> CreateProfileUiModel) {
        savedStateHandle[ProfileKey] = action.invoke(state)
    }
}
