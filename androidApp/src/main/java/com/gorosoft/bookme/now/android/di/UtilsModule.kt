package com.gorosoft.bookme.now.android.di

import com.google.android.gms.location.LocationServices
import com.gorosoft.bookme.now.android.managers.LocationTracker
import com.gorosoft.bookme.now.android.managers.OneTimeLocationTracker
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun utilsModule() = module {
    factory<LocationTracker> {
        OneTimeLocationTracker(
            application = get(),
            locationClient = LocationServices.getFusedLocationProviderClient(androidApplication())
        )
    }
}
