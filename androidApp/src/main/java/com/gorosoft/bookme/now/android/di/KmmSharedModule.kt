package com.gorosoft.bookme.now.android.di

import android.app.Application
import com.gorosoft.bookme.now.managers.KMMUserDefaults
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object KmmSharedModule {

    @Provides
    fun provideKMMUserDefaults(app: Application): KMMUserDefaults {
        return KMMUserDefaults(app)
    }
}
