package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.sources.local.datasource.ProfileCacheDataSource
import com.gorosoft.bookme.now.data.sources.local.datasource.ProfileCacheDataSourceProtocol
import com.gorosoft.bookme.now.data.sources.network.datasource.BookingRemoteDataSource
import com.gorosoft.bookme.now.data.sources.network.datasource.PlaceRemoteDataSource
import com.gorosoft.bookme.now.data.sources.network.datasource.ProfileRemoteDataSource
import com.gorosoft.bookme.now.data.sources.network.ktor.HeadersHolder
import com.gorosoft.bookme.now.data.sources.network.ktor.HeadersHolderProtocol
import com.gorosoft.bookme.now.data.sources.network.ktor.TokenHolder
import com.gorosoft.bookme.now.data.sources.network.ktor.TokenHolderProtocol
import org.koin.dsl.module

fun dataSourceModule() = module {
    factory<ProfileCacheDataSourceProtocol> {
        ProfileCacheDataSource(
            profileDao = get(),
        )
    }
    factory<ProfileRemoteDataSource> {
        ProfileRemoteDataSource(
            client = get(),
        )
    }

    factory<BookingRemoteDataSource> {
        BookingRemoteDataSource(
            client = get(),
        )
    }

    factory<PlaceRemoteDataSource> {
        PlaceRemoteDataSource(
            client = get(),
        )
    }

    single<TokenHolderProtocol> {
        TokenHolder(
            context = get(),
        )
    }

    single<HeadersHolderProtocol> { HeadersHolder() }
}
