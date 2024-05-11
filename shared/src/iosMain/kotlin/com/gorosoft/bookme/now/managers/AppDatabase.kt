package com.gorosoft.bookme.now.managers

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.gorosoft.bookme.now.data.database.AppDatabase
import com.gorosoft.bookme.now.data.database.appDbFileName
import com.gorosoft.bookme.now.data.database.instantiateImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun createRoomDatabase(): AppDatabase {
    val dbFile = NSHomeDirectory() + "/$appDbFileName"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
