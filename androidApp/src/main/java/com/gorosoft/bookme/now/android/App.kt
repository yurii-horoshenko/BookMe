package com.gorosoft.bookme.now.android

import android.app.Application
import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.managers.KMMUserDefaults
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var defaults: KMMUserDefaults

    override fun onCreate() {
        super.onCreate()
        KtorManager.setAccessToken(defaults.accessToken)
    }
}
