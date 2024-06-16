package com.gorosoft.bookme.now.android

import android.app.Application
import com.gorosoft.bookme.now.android.di.uiUseCaseModule
import com.gorosoft.bookme.now.android.di.utilsModule
import com.gorosoft.bookme.now.android.di.viewModelModule
import com.gorosoft.bookme.now.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                sharedModule(),
                uiUseCaseModule(),
                viewModelModule(),
                utilsModule()
            )
        }
    }
}
