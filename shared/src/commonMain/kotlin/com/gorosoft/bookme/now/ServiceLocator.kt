package com.gorosoft.bookme.now

import com.gorosoft.bookme.now.data.database.RealmManager
import com.gorosoft.bookme.now.data.database.datasource.ProfileCacheDataSource
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

    private val realm get() = RealmManager.realm

    private val httpClient by lazy { KtorManager.client }

    private val profileRemote by lazy { ProfileRemoteDataSource(httpClient) }

    private val placeRemote by lazy { PlaceRemoteDataSource(httpClient) }

    private val bookingRemote by lazy { BookingRemoteDataSource(httpClient) }

    private val profileCache by lazy { ProfileCacheDataSource(realm) }

    val profileRepository: ProfileRepositoryProtocol by lazy {
        ProfileRepository(remote = profileRemote, cache = profileCache)
    }

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

    val loginUseCase get() = LoginUseCase(profileRepository)

    val isLoggedInUseCase: (KMMUserDefaults) -> IsLoggedInUseCase =
        { defaults -> IsLoggedInUseCase(defaults) }
}