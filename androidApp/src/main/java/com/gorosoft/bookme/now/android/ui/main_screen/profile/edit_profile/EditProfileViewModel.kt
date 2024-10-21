package com.gorosoft.bookme.now.android.ui.main_screen.profile.edit_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gorosoft.bookme.now.android.ui_models.EditProfileUiModel
import com.gorosoft.bookme.now.data.sources.network.models.profile.ProfileGenderType
import java.time.LocalDate

private const val EditProfileKey = "EditYourProfile"

class EditProfileViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val state get() = profileState.value

    val profileState = savedStateHandle.getStateFlow(EditProfileKey, EditProfileUiModel())

    fun updateName(newFirstName: String) {
        updateState { copy(firstName = newFirstName) }
    }

    fun updateSecondName(newSecondName: String) {
        updateState { copy(secondName = newSecondName) }
    }

//    fun updatePhone(phone: String) {
//        updateState { copy(phone = phone) }
//    }

    fun updateEmail(email: String) {
        updateState { copy(email = email) }
    }

    fun updateAddress(address: String) {
        updateState { copy(address = address) }
    }

    fun updateGender(gender: ProfileGenderType) {
        updateState { copy(gender = gender) }
    }

    fun updateDateOfBirth(date: LocalDate) {
        updateState { copy(dateOfBirthDate = date) }
    }

    private fun updateState(action: EditProfileUiModel.() -> EditProfileUiModel) {
        savedStateHandle[EditProfileKey] = action.invoke(state)
    }
}
