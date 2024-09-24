package com.gorosoft.bookme.now.android.ui.main_screen.profile.edit_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gorosoft.bookme.now.android.ui_models.EditProfileUiModel
import com.gorosoft.bookme.now.domain.models.UserGenderType
import java.time.LocalDate

private const val ProfileKey = "EditYourProfile"

class EditProfileViewModel(
    private val savedStateHandle: SavedStateHandle,
   // private val profileIsValidUseCase: ProfileUiIsValidUseCase,
) : ViewModel() {

    private val state get() = profileState.value

    val profileState = savedStateHandle.getStateFlow(ProfileKey, EditProfileUiModel())

//    val buttonEnablingState: StateFlow<Boolean> = profileState.map { uiModel ->
//        profileIsValidUseCase.execute(uiModel)
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000),
//        initialValue = false
//    )

    fun updateName(newFullName: String) {
        updateState { copy(fullName = newFullName) }
    }

    fun updateGender(gender: UserGenderType) {
        updateState { copy(gender = gender) }
    }

    fun updateDateOfBirth(date: LocalDate) {
        updateState { copy(dateOfBirthDate = date) }
    }

    private fun updateState(action: EditProfileUiModel.() -> EditProfileUiModel) {
        savedStateHandle[ProfileKey] = action.invoke(state)
    }
}