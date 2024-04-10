package com.gorosoft.bookme.now.data.database

import com.gorosoft.bookme.now.data.database.model.Profile
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class RealmManager {

    fun setup() {
        // Creates a realm with default configuration values
        val config = RealmConfiguration.create(
            // Pass object classes for the realm schema
            schema = setOf(Profile::class)
        )
        // Open the realm with the configuration object
        val realm = Realm.open(config)
    }

}