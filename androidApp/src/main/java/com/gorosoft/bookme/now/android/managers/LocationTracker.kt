package com.gorosoft.bookme.now.android.managers

import android.location.Location

interface LocationTracker {

    suspend fun getCurrentLocation(): Location?
}
