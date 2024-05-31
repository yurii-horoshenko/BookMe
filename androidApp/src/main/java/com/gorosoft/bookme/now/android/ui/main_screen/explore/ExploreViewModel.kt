package com.gorosoft.bookme.now.android.ui.main_screen.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosoft.bookme.now.android.managers.LocationTracker
import com.gorosoft.bookme.now.android.managers.LocationTracker.LocationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExploreViewModel(
    private val locationTracker: LocationTracker,
) : ViewModel() {

    private val _isShowLocationRationale = MutableStateFlow(false)
    val isShowLocationRationale = _isShowLocationRationale.asStateFlow()

    private val _isShowNavigateToSettingsState = MutableStateFlow(false)
    val isShowNavigateToSettingsState = _isShowNavigateToSettingsState.asStateFlow()

    private val _isShowMapState = MutableStateFlow(false)
    val isShowMapState = _isShowMapState.asStateFlow()

    private val _currentLocation = MutableStateFlow<LocationResult?>(null)
    val currentLocation = _currentLocation.asStateFlow()

    fun navigateToSettings() {
        _isShowMapState.update { false }
        _isShowNavigateToSettingsState.update { true }
    }

    fun showMap() {
        viewModelScope.launch {
            val location = locationTracker.getCurrentLocation()
            _currentLocation.update { location }
            _isShowNavigateToSettingsState.update { false }
            _isShowMapState.update { true }
        }
    }

    fun showLocationRationale(isShow: Boolean) {
        _isShowLocationRationale.update { isShow }
    }
}
