package com.gorosoft.bookme.now.managers

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.gorosoft.bookme.now.data.database.AppDatabase
import com.gorosoft.bookme.now.data.database.appDbFileName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun createRoomDatabase(): AppDatabase {
    val dbFile = "${fileDirectory()}/$appDbFileName"
    // or val dbFile = NSHomeDirectory() + "/appDbFileName"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
