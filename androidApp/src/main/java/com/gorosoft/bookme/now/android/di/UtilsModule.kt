package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.android.managers.DefaultLocationTracker
import com.gorosoft.bookme.now.android.managers.LocationTracker
import org.koin.dsl.module

fun utilsModule() = module {
    factory<LocationTracker> {
        DefaultLocationTracker(
            application = get()
        )
    }
}
