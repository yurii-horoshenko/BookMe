package com.gorosoft.bookme.now.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gorosoft.bookme.now.data.database.model.ProfileEntity
import com.gorosoft.bookme.now.data.sources.local.roomdb.queries.profile.ProfileDao

internal const val appDbFileName = "bookme_now.db"

@Database(
    entities = [
        ProfileEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
}
