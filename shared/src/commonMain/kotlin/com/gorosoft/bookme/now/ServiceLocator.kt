package com.gorosoft.bookme.now

import com.gorosoft.bookme.now.data.database.dao.ProfileDao
import com.gorosoft.bookme.now.data.database.datasource.ProfileCacheDataSource
import com.gorosoft.bookme.now.data.database.datasource.ProfileCacheDataSourceProtocol
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
import com.gorosoft.bookme.now.domain.usecase.HadTutorialUseCase
import com.gorosoft.bookme.now.domain.usecase.IsLoggedInUseCase
import com.gorosoft.bookme.now.domain.usecase.LoginUseCase
import com.gorosoft.bookme.now.domain.usecase.SetHadTutorialUseCase
import com.gorosoft.bookme.now.managers.KMMUserDefaults

// utility class to provide dependencies for iOS
object ServiceLocator {

    private val httpClient by lazy { KtorManager.client }

    private val profileRemote by lazy { ProfileRemoteDataSource(httpClient) }

    private val placeRemote by lazy { PlaceRemoteDataSource(httpClient) }

    private val bookingRemote by lazy { BookingRemoteDataSource(httpClient) }

    private val profileCache: (ProfileDao) -> ProfileCacheDataSourceProtocol =
        { dao -> ProfileCacheDataSource(dao) }

    val profileRepository: (ProfileCacheDataSourceProtocol) -> ProfileRepositoryProtocol =
        { cache -> ProfileRepository(remote = profileRemote, cache = cache) }

    val placeRepository: PlaceRepositoryProtocol by lazy {
        PlaceRepository(placeRemote)
    }

    val bookingRepository: BookingRepositoryProtocol by lazy {
        BookingRepository(bookingRemote)
    }

    val hadTutorialUseCase: (KMMUserDefaults) -> HadTutorialUseCase =
        { defaults -> HadTutorialUseCase(defaults) }

    val setHadTutorialUseCase: (KMMUserDefaults) -> SetHadTutorialUseCase =
        { defaults -> SetHadTutorialUseCase(defaults) }

    val loginUseCase: (ProfileRepositoryProtocol) -> LoginUseCase =
        { profileRepository -> LoginUseCase(profileRepository) }

    val isLoggedInUseCase: (KMMUserDefaults) -> IsLoggedInUseCase =
        { defaults -> IsLoggedInUseCase(defaults) }
}
