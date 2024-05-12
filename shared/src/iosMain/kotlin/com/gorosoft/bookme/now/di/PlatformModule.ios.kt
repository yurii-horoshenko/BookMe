package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.database.AppDatabase
import com.gorosoft.bookme.now.managers.KMMUserDefaults
import com.gorosoft.bookme.now.managers.createRoomDatabase
import org.koin.dsl.module
import platform.darwin.NSObject

actual fun platformModule() = module {
    single<KMMUserDefaults> { KMMUserDefaults(context = NSObject()) }
    single<AppDatabase> { createRoomDatabase() }
}