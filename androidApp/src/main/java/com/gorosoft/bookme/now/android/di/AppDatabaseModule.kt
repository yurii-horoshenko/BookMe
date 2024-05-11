package com.gorosoft.bookme.now.android.di

import android.app.Application
import com.gorosoft.bookme.now.data.database.AppDatabase
import com.gorosoft.bookme.now.data.database.dao.ProfileDao
import com.gorosoft.bookme.now.managers.createRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppDatabaseModule {

    @Provides
    fun provideAppDatabase(context: Application): AppDatabase {
        return createRoomDatabase(context)
    }

    @Provides
    fun provideProfileDao(appDatabase: AppDatabase): ProfileDao {
        return appDatabase.profileDao()
    }
}
