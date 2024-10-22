package com.gorosoft.bookme.now.di

import org.koin.dsl.module

fun sharedModule() = module {
    includes(
        platformModule(),
        networkModule(),
        daoModule(),
        dataSourceModule(),
        repositoryModule(),
        useCaseModule(),
    )
}
