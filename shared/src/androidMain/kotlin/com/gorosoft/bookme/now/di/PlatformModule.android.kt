package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.database.AppDatabase
import com.gorosoft.bookme.now.utils.KMMUserDefaults
import com.gorosoft.bookme.now.utils.createRoomDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single<KMMUserDefaults> { KMMUserDefaults(context = get()) }
    single<AppDatabase> { createRoomDatabase(context = get()) }
}
