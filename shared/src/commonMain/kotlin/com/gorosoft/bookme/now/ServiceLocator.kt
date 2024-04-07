package com.gorosoft.bookme.now

import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.data.network.datasource.BookingRemoteDataSource
import com.gorosoft.bookme.now.data.network.datasource.PlaceRemoteDataSource
import com.gorosoft.bookme.now.data.network.datasource.ProfileRemoteDataSource
import com.gorosoft.bookme.now.data.repositories.BookingRepository
import com.gorosoft.bookme.now.data.repositories.PlaceRepository
import com.gorosoft.bookme.now.data.repositories.ProfileRepository
import com.gorosoft.bookme.now.domain.repository.BookingRepositoryProtocol
import com.gorosoft.bookme.now.domain.repository.PlaceRepositoryProtocol
import com.gorosoft.bookme.now.domain.repository.ProfileRepositoryProtocol

// utility class to provide dependencies for iOS
object ServiceLocator {

    private val httpClient by lazy { KtorManager.client }

    private val profileRemote by lazy { ProfileRemoteDataSource(httpClient) }

    private val placeRemote by lazy { PlaceRemoteDataSource(httpClient) }

    private val bookingRemote by lazy { BookingRemoteDataSource(httpClient) }

    val profileRepository: ProfileRepositoryProtocol by lazy {
        ProfileRepository(profileRemote)
    }

    val placeRepository: PlaceRepositoryProtocol by lazy {
        PlaceRepository(placeRemote)
    }

    val bookingRepository: BookingRepositoryProtocol by lazy {
        BookingRepository(bookingRemote)
    }
}