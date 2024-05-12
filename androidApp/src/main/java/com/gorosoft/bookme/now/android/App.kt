package com.gorosoft.bookme.now.android

import android.app.Application
import com.gorosoft.bookme.now.android.di.uiUseCaseModule
import com.gorosoft.bookme.now.android.di.viewModelModule
import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.di.sharedModule
import com.gorosoft.bookme.now.managers.KMMUserDefaults
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    private val defaults: KMMUserDefaults by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                sharedModule(),
                uiUseCaseModule(),
                viewModelModule(),
            )
        }

        KtorManager.setAccessToken(defaults.accessToken)
    }
}
