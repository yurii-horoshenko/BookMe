package com.gorosoft.bookme.now.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gorosoft.bookme.now.data.database.model.ProfileEntity

@Dao
interface ProfileDao {

    @Query("SELECT * FROM ProfileEntity WHERE id = 0")
    suspend fun getProfile(): ProfileEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profile: ProfileEntity)

    @Query("DELETE FROM ProfileEntity")
    suspend fun clearProfileTable()
}
