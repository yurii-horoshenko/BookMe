package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.repositories.BookingRepository
import com.gorosoft.bookme.now.data.repositories.PlaceRepository
import com.gorosoft.bookme.now.data.repositories.ProfileRepository
import com.gorosoft.bookme.now.domain.repositories.BookingRepositoryProtocol
import com.gorosoft.bookme.now.domain.repositories.PlaceRepositoryProtocol
import com.gorosoft.bookme.now.domain.repositories.ProfileRepositoryProtocol
import org.koin.dsl.module

fun repositoryModule() = module {
    factory<ProfileRepositoryProtocol> { ProfileRepository() }

    factory<BookingRepositoryProtocol> {
        BookingRepository()
    }

    factory<PlaceRepositoryProtocol> {
        PlaceRepository()
    }
}
