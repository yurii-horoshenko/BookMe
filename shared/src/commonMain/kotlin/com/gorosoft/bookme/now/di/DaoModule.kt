package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.sources.local.roomdb.AppDatabase
import com.gorosoft.bookme.now.data.sources.local.models.profile.ProfileDao
import org.koin.dsl.module

fun daoModule() = module {
    single<ProfileDao> { val db: AppDatabase = get(); db.profileDao() }
}
