package com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosoft.bookme.now.android.ui_models.CreateProfileUiModel
import com.gorosoft.bookme.now.domain.models.CreateProfileModel
import com.gorosoft.bookme.now.domain.models.UserGender
import com.gorosoft.bookme.now.domain.use_case.CreateProfileIsValidUseCase
import com.gorosoft.bookme.now.network.KtorManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate
import javax.inject.Inject

private const val ProfileKey = "CreateYourProfile"

@HiltViewModel
class CreateYourProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val profileIsValidUseCase: CreateProfileIsValidUseCase,
) : ViewModel() {

    private val state get() = profileState.value

    val profileState = savedStateHandle.getStateFlow(ProfileKey, CreateProfileUiModel())

    val buttonEnablingState: StateFlow<Boolean> = profileState.map { uiModel ->
        profileIsValidUseCase.execute()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), initialValue = false)

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
