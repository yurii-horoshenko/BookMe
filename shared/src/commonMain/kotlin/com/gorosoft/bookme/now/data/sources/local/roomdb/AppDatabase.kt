package com.gorosoft.bookme.now.data.sources.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gorosoft.bookme.now.data.sources.local.models.profile.ProfileDao
import com.gorosoft.bookme.now.data.sources.local.models.profile.ProfileEntity

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
