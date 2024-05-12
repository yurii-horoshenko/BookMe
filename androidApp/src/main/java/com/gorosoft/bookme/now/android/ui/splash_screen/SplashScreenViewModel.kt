package com.gorosoft.bookme.now.android.ui.splash_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosoft.bookme.now.domain.usecase.HadTutorialUseCase
import com.gorosoft.bookme.now.domain.usecase.IsLoggedInUseCase
import com.gorosoft.bookme.now.domain.usecase.LoginUseCase
import com.gorosoft.bookme.now.onError
import com.gorosoft.bookme.now.onFailure
import com.gorosoft.bookme.now.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class SplashScreenEffect {
    data object NavigateToLogin : SplashScreenEffect()
    data object NavigateToWelcome : SplashScreenEffect()
    data object NavigateToHome : SplashScreenEffect()
    data class ShowError(val message: String) : SplashScreenEffect()
}

class SplashScreenViewModel(
    hadTutorialUseCase: HadTutorialUseCase,
    isLoggedInUseCase: IsLoggedInUseCase,
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private val _effects = MutableStateFlow<SplashScreenEffect?>(null)
    val effects get() = _effects.filterNotNull()

    init {
        when {
            isLoggedInUseCase.execute() -> login()
            hadTutorialUseCase.execute() -> _effects.update { SplashScreenEffect.NavigateToLogin }
            else -> _effects.update { SplashScreenEffect.NavigateToWelcome }
        }
    }

    private fun login() {
        viewModelScope.launch {
            loginUseCase.execute()
                .onSuccess {
                    _effects.update { SplashScreenEffect.NavigateToHome }
                }
                ?.onError { error ->
                    _effects.update { SplashScreenEffect.ShowError(error.message) }
                }
                ?.onFailure { failure ->
                    _effects.update {
                        SplashScreenEffect.ShowError(failure.exception.message.orEmpty())
                    }
                }
        }
    }

    fun consumeEffect() {
        _effects.update { null }
    }
}
