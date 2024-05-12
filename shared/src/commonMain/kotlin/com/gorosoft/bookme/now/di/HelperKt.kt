package com.gorosoft.bookme.now.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(sharedModule())
    }
}