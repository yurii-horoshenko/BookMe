package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.network.KtorManager
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun networkModule() = module {
    single<HttpClient> { KtorManager.client }
}
