package com.gorosoft.bookme.now.android.ui.utils

import android.location.Location
import com.google.android.gms.maps.model.LatLng

val Location.latLng: LatLng
    get() = LatLng(latitude, longitude)
