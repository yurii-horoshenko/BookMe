package com.gorosoft.bookme.now.android.ui.main_screen.explore

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor() : ViewModel() {

    private val _isShowLocationRationale = MutableStateFlow(false)
    val isShowLocationRationale = _isShowLocationRationale.asStateFlow()

    private val _isShowNavigateToSettingsState = MutableStateFlow(false)
    val isShowNavigateToSettingsState = _isShowNavigateToSettingsState.asStateFlow()

    private val _isShowMapState = MutableStateFlow(false)
    val isShowMapState = _isShowMapState.asStateFlow()

    fun navigateToSettings() {
        _isShowMapState.update { false }
        _isShowNavigateToSettingsState.update { true }
    }

    fun showMap() {
        _isShowNavigateToSettingsState.update { false }
        _isShowMapState.update { true }
    }

    fun showLocationRationale(isShow: Boolean) {
        _isShowLocationRationale.update { isShow }
    }
}
