package com.gorosoft.bookme.now

import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.data.network.datasource.BookingRemoteDataSource
import com.gorosoft.bookme.now.data.network.datasource.PlaceRemoteDataSource
import com.gorosoft.bookme.now.data.network.datasource.UserRemoteDataSource
import com.gorosoft.bookme.now.data.repositories.BookingRepository
import com.gorosoft.bookme.now.data.repositories.PlaceRepository
import com.gorosoft.bookme.now.data.repositories.UserRepository
import com.gorosoft.bookme.now.domain.repository.BookingRepositoryProtocol
import com.gorosoft.bookme.now.domain.repository.PlaceRepositoryProtocol
import com.gorosoft.bookme.now.domain.repository.UserRepositoryProtocol

// utility class to provide dependencies for iOS
object ServiceLocator {

    private val httpClient by lazy { KtorManager.client }

    private val userRemote by lazy { UserRemoteDataSource(httpClient) }

    private val placeRemote by lazy { PlaceRemoteDataSource(httpClient) }

    private val bookingRemote by lazy { BookingRemoteDataSource(httpClient) }

    val userRepository: UserRepositoryProtocol by lazy {
        UserRepository(userRemote)
    }

    val placeRepository: PlaceRepositoryProtocol by lazy {
        PlaceRepository(placeRemote)
    }

    val bookingRepository: BookingRepositoryProtocol by lazy {
        BookingRepository(bookingRemote)
    }
}