package com.gorosoft.bookme.now.managers

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.gorosoft.bookme.now.data.database.AppDatabase
import com.gorosoft.bookme.now.data.database.appDbFileName
import kotlinx.coroutines.Dispatchers

fun createRoomDatabase(context: Context): AppDatabase {
    val dbFile = context.getDatabasePath(appDbFileName)
    return Room.databaseBuilder<AppDatabase>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
