package com.bookme.cache


class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getAllProfiles(): ProfileEntity {
        return dbQuery.getProfile().executeAsOne()
    }

    internal fun insertProfile(profile: ProfileEntity) {
        dbQuery.insertProfile(
            fullName = profile.fullName,
            birthday = profile.birthday,
            gender = profile.gender,
            email = profile.email,
            phone = profile.phone,
            isExist = profile.isExist,
        )
    }

    internal fun clearProfileTable() {
        dbQuery.deleteProfile()
    }
}
