package com.gorosoft.bookme.now.android.ui.account_setup

import androidx.compose.runtime.mutableStateOf
import androidx.credentials.Credential
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.account_setup.Effect.ShowError
import com.gorosoft.bookme.now.android.ui.usecase.LoginWithGoogleUiUseCase
import com.gorosoft.bookme.now.android.ui.utils.TextHolder
import com.gorosoft.bookme.now.data.sources.network.ktor.onError
import com.gorosoft.bookme.now.data.sources.network.ktor.onFailure
import com.gorosoft.bookme.now.data.sources.network.ktor.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class Effect {
    data object NavigateToHome : Effect()
    data class ShowError(val message: TextHolder) : Effect()
}

class LoginViewModel(
    private val loginWithGoogleUiUseCase: LoginWithGoogleUiUseCase,
) : ViewModel() {

    private val _effect = MutableStateFlow<Effect?>(null)
    val effect get() = _effect.asStateFlow().filterNotNull()

    val showLoading = mutableStateOf(false)

    fun loginWithGoogle(credential: Credential) {
        showLoading.value = true
        viewModelScope.launch {
            loginWithGoogleUiUseCase.execute(credential)
                .onSuccess { _effect.update { Effect.NavigateToHome } }
                ?.onFailure {
                    _effect.update {
                        ShowError(TextHolder.Resource(R.string.sorry_something_went_wrong))
                    }
                }
                ?.onError {
                    _effect.update {
                        ShowError(TextHolder.Resource(R.string.sorry_something_went_wrong))
                    }
                }
            showLoading.value = false
        }
    }

    fun consumeEffect() {
        _effect.update { null }
    }

    fun showErrorMessage(message: String) {
        _effect.update { ShowError(TextHolder.Text(message)) }
    }
}
