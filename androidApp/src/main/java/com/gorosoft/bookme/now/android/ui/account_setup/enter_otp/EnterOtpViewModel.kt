package com.gorosoft.bookme.now.android.ui.account_setup.enter_otp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class EnterOtpEffects {

    data object ShowSuccessDialog : EnterOtpEffects()
}

@HiltViewModel
class EnterOtpViewModel @Inject constructor() : ViewModel() {

    private val _resendCodeFlow = MutableStateFlow(59)
    val resendCodeFlow get() = _resendCodeFlow.asStateFlow()

    private val _otpStateFlow = MutableStateFlow("")
    val otpStateFlow get() = _otpStateFlow.asStateFlow()

    private val _effect = MutableStateFlow<EnterOtpEffects?>(null)
    val effect get() = _effect.filterNotNull()

    private val tickerFlow = flow {
        for (i in 59 downTo 0) {
            delay(1000)
            emit(i)
        }
    }

    private var tickerJob: Job? = null

    init {
        initTicker()
        viewModelScope.launch {
            otpStateFlow.collectLatest { otp ->
                if (otp == "1111") {
                    _effect.update { EnterOtpEffects.ShowSuccessDialog }
                }
            }
        }
    }

    fun updateOtp(otp: String) {
        _otpStateFlow.update { otp }
    }

    private fun initTicker() {
        tickerJob?.cancel()
        tickerJob = viewModelScope.launch {
            tickerFlow.collect { newValue -> _resendCodeFlow.update { newValue } }
        }
    }

    fun resendOtp() {
        // network call
        initTicker()
    }

    fun consumeEffect() {
        _effect.update { null }
    }
}
