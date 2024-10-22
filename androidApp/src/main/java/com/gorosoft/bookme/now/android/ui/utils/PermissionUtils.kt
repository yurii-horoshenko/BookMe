@file:OptIn(ExperimentalPermissionsApi::class)

package com.gorosoft.bookme.now.android.ui.utils

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.isGranted

val MultiplePermissionsState.isAllPermissionGranted: Boolean
    get() = permissions.all { it.status.isGranted }
