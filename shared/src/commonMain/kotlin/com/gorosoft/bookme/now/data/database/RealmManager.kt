package com.gorosoft.bookme.now.data.database

import com.gorosoft.bookme.now.data.database.model.ProfileEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

private val tables = setOf(ProfileEntity::class)

object RealmManager {

    val realm by lazy {
        val config = RealmConfiguration.create(schema = tables)
        Realm.open(config)
    }
}